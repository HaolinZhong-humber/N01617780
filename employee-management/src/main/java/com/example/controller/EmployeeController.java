package com.example.controller;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // 显示所有员工 (返回 index.html)
    @GetMapping
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "index";
    }

    // 显示新增员工表单 (返回 addEmployee.html)
    @GetMapping("/new")
    public String createEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }

    // 提交新增员工
    @PostMapping
    public String saveEmployee(@Valid @ModelAttribute Employee employee,
                               BindingResult result,
                               Model model) {
        if (result.hasErrors()) {
            model.addAttribute("employee", employee);
            return "addEmployee";
        }
        employeeService.addEmployee(employee);
        return "redirect:/employees";
    }

    // 显示编辑员工表单 (返回 updateEmployee.html)
    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model) {
        Optional<Employee> employeeOpt = employeeService.getEmployeeById(id);
        if (employeeOpt.isPresent()) {
            model.addAttribute("employee", employeeOpt.get());
            return "updateEmployee";
        }
        model.addAttribute("error", "Employee not found!");
        return "redirect:/employees";
    }

    // 提交更新员工
    @PostMapping("/update")
    public String updateEmployee(@Valid @ModelAttribute Employee employee,
                                 BindingResult result,
                                 Model model) {
        if (result.hasErrors()) {
            model.addAttribute("employee", employee);
            return "updateEmployee";
        }
        employeeService.updateEmployee(employee);
        return "redirect:/employees";
    }

    // 删除员工
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
