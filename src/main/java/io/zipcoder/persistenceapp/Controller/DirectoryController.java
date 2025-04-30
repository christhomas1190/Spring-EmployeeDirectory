package io.zipcoder.persistenceapp.Controller;

import io.zipcoder.persistenceapp.Department;
import io.zipcoder.persistenceapp.Employee;
import io.zipcoder.persistenceapp.Services.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API")
public class DirectoryController {

    @Autowired
    private DirectoryService service;

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return service.createEmployee(employee);
    }
    @PostMapping("/department")
    public Department createDepartment(@RequestBody Department department) {
        return service.createDepartment(department);
    }
    @PutMapping("/employee/{id}/manager/{managerId}")
    public Employee updateManager(@PathVariable Long id, @PathVariable Long managerId) {
        return service.updateEmployeeManager(id, managerId);
    }
    @PutMapping("/department/{deptId}/manager/{managerId}")
    public Department updateDepartmentManager(@PathVariable Long deptId, @PathVariable Long managerId) {
        return service.setDepartmentManager(deptId, managerId);
    }
    @GetMapping("/manager/{managerId}/employees")
    public List<Employee> getEmployeesByManager(@PathVariable Long managerId) {
        return service.getEmployeesByManager(managerId);
    }

    @GetMapping("/employees/unmanaged")
    public List<Employee> getUnmanagedEmployees() {
        return service.getUnmanagedEmployees();
    }

    @GetMapping("/department/{deptId}/employees")
    public List<Employee> getEmployeesByDepartment(@PathVariable Long deptId) {
        return service.getEmployeesByDepartment(deptId);
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
    }

    @DeleteMapping("/department/{deptId}/employees")
    public void deleteEmployeesByDepartment(@PathVariable Long deptId) {
        service.deleteEmployeesByDepartment(deptId);
    }
}
