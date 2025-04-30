package io.zipcoder.persistenceapp.Services;

import io.zipcoder.persistenceapp.Department;
import io.zipcoder.persistenceapp.Employee;
import io.zipcoder.persistenceapp.Repositories.DepartmentRepository;
import io.zipcoder.persistenceapp.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;


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

}
