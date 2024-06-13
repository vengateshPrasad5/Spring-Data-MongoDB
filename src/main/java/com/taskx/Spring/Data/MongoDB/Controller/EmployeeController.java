package com.taskx.Spring.Data.MongoDB.Controller;

import com.taskx.Spring.Data.MongoDB.Entity.Employee;
import com.taskx.Spring.Data.MongoDB.Service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("employees")
@AllArgsConstructor
public class EmployeeController {

    EmployeeService employeeService;
    @GetMapping()
    public String getAllEmployees(Model model){
        List<Employee> employees = employeeService.getAllEmployee();
        model.addAttribute("employees", employees);
        return "employee_list";
    }

    @GetMapping("/{id}")
    public String getEmployeeById(@PathVariable("id") String id, Model model){
        System.out.println("id = " + id);
        Employee employee = employeeService.getEmployeeById(id).get();
        System.out.println("employee = " + employee);
        model.addAttribute("employee", employee);
        return "employee_detail";
    }

    @GetMapping("/addForm")
    public String addEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee_form";
    }

    @PostMapping("/saveEmployee")
    public String addEmployee(@ModelAttribute Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/";
    }
    @GetMapping("/editForm/{id}")
    public String editEmployeeForm(@PathVariable("id") String id, Model model) {
        Employee employee = employeeService.getEmployeeById(id).orElse(null);
        model.addAttribute("employee", employee);
        return "employee_form";
    }

    @PostMapping("/editEmployee/{id}")
    public String updateEmployee(@PathVariable("id") String id,@ModelAttribute Employee employee){
        employeeService.updateEmployee(id,employee);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable("id") String id){
        employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }
}
