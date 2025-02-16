package com.example.controller;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import jakarta.validation.Valid;
<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
=======
>>>>>>> 3d7697b (lab5 submission)
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
@Controller
=======
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
>>>>>>> 3d7697b (lab5 submission)
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

<<<<<<< HEAD
    @GetMapping("/")
    public String getAllEmployees(Model model) {
        model.addAttribute("employeeList", employeeService.getAllEmployees());
        return "index";
    }

    @GetMapping("/showAddEmployeeForm")
    public String showAddEmployeeForm(Model model) {
=======
    @GetMapping
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "index";
    }

    @GetMapping("/new")
    public String createEmployeeForm(Model model) {
>>>>>>> 3d7697b (lab5 submission)
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }

<<<<<<< HEAD
    @PostMapping("/addEmployee")
    public String addEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addEmployee";
        }
        employeeService.addEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "updateEmployee";
    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateEmployee";
        }
        employeeService.updateEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
    @GetMapping("/getEmployee/{id}")
    @ResponseBody
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.getEmployeeById(id)
                .map(employee -> ResponseEntity.ok().body(employee))  // 如果找到，返回 200 + JSON
                .orElse(ResponseEntity.notFound().build());  // 如果找不到，返回 404
    }

=======
    @PostMapping
    public String saveEmployee(@Valid @ModelAttribute Employee employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("employee", employee);
            return "addEmployee";
        }
        employeeService.addEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
        } else {
            model.addAttribute("error", "Employee not found!");
            return "index";
        }
        return "updateEmployee";
    }

    @PostMapping("/update")
    public String updateEmployee(@Valid @ModelAttribute Employee employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("employee", employee);
            return "updateEmployee";
        }
        employeeService.updateEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
>>>>>>> 3d7697b (lab5 submission)
}
