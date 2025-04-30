package io.zipcoder.persistenceapp.Repositories;

import io.zipcoder.persistenceapp.Department;
import io.zipcoder.persistenceapp.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByManager(Employee manager);
    List<Employee> findByDepartment(Department department);
    List<Employee> findByManagerIsNull();

    void deleteAll(List<Employee> emps);
}
