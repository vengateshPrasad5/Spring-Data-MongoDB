package com.taskx.Spring.Data.MongoDB.Service.EmployeeImpl;

import com.taskx.Spring.Data.MongoDB.Entity.Employee;
import com.taskx.Spring.Data.MongoDB.Repository.EmployeeRepository;
import com.taskx.Spring.Data.MongoDB.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeImpl implements EmployeeService {

    EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(String empId) {
        return employeeRepository.findById(empId);
    }

    @Override
    public void deleteEmployeeById(String empId) {
         employeeRepository.deleteById(empId);
    }

    @Override
    public Employee updateEmployee(String id,Employee employee) {
        Employee updateEmp = employeeRepository.findById(id).get();
        updateEmp.setEmpName(employee.getEmpName());
        updateEmp.setEmpEmail(employee.getEmpEmail());
        updateEmp.setEmpLocation(employee.getEmpLocation());
        return employeeRepository.save(updateEmp);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
