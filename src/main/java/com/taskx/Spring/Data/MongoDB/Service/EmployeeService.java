package com.taskx.Spring.Data.MongoDB.Service;

import com.taskx.Spring.Data.MongoDB.Entity.Employee;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> getAllEmployee();
    Optional<Employee> getEmployeeById(String empId);
    void deleteEmployeeById(String empId);
    Employee updateEmployee(Employee employee);
    Employee addEmployee(Employee employee);

}
