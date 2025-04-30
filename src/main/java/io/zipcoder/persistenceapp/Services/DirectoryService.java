package io.zipcoder.persistenceapp.Services;

import io.zipcoder.persistenceapp.Department;
import io.zipcoder.persistenceapp.Employee;
import io.zipcoder.persistenceapp.Repositories.DepartmentRepository;
import io.zipcoder.persistenceapp.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public class DirectoryService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public Department createDepartment(Department department){
        return departmentRepository.save(department);
    }
    public Employee updateEmployeeManager(Long employeeId, Long managerId){
        Employee employee=employeeRepository.findOne(employeeId);
        Employee manager= employeeRepository.findOne(managerId);
        employee.setManager(manager);
        employee.setDepartment((manager.getDepartment()));
        return employeeRepository.save(employee);
    }

    public Department setDepartmentManager(Long deptId, Long managerId){
        Department dept = departmentRepository.findOne(deptId);
        Employee manager = employeeRepository.findOne(managerId);
        dept.setManager(manager);
        return departmentRepository.save(dept);
    }
    public List<Employee> getEmployeesByManager(Long managerId) {
        Employee manager = employeeRepository.findOne(managerId);
        return employeeRepository.findByManager(manager);
    }
    public List<Employee> getReportingHierarchy(Long employeeId) {
        new Exception("Recursive hierarchy builder goes here");
        List<Employee> employees = List.of();
        return employees;
    }
    public List<Employee> getUnmanagedEmployees() {
        return employeeRepository.findByManagerIsNull();
    }

    public List<Employee> getEmployeesByDepartment(Long deptId) {
        Department dept = departmentRepository.findOne(deptId);
        return employeeRepository.findByDepartment(dept);
    }

    public void deleteEmployee(Long empId) {
        employeeRepository.delete(empId);
    }

    public void deleteEmployeesByDepartment(Long deptId) {
        Department dept = departmentRepository.findOne(deptId);
        List<Employee> emps = employeeRepository.findByDepartment(dept);
        employeeRepository.deleteAll(emps);
    }}
