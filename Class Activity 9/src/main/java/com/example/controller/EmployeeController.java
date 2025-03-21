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

<<<<<<< HEAD
    // 显示所有员工 (返回 index.html)
=======
>>>>>>> 7843eac (Added Class Activity 9)
    @GetMapping
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "index";
    }

<<<<<<< HEAD
    // 显示新增员工表单 (返回 addEmployee.html)
=======
>>>>>>> 7843eac (Added Class Activity 9)
    @GetMapping("/new")
    public String createEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }

<<<<<<< HEAD
    // 提交新增员工
=======
>>>>>>> 7843eac (Added Class Activity 9)
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

<<<<<<< HEAD
    // 显示编辑员工表单 (返回 updateEmployee.html)
=======
>>>>>>> 7843eac (Added Class Activity 9)
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

<<<<<<< HEAD
    // 提交更新员工
=======
>>>>>>> 7843eac (Added Class Activity 9)
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

<<<<<<< HEAD
    // 删除员工
=======
>>>>>>> 7843eac (Added Class Activity 9)
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
