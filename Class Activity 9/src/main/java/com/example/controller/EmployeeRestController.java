package com.example.controller;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

<<<<<<< HEAD
    // GET: 获取所有员工 (返回 JSON 数组)
=======
    // GET: 获取所有员工 (返回 JSON)
>>>>>>> 7843eac (Added Class Activity 9)
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    // GET: 根据 ID 获取单个员工
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employeeOpt = employeeService.getEmployeeById(id);
        return employeeOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST: 新增员工
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
<<<<<<< HEAD
        Employee createdEmployee = employeeService.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
=======
        Employee created = employeeService.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
>>>>>>> 7843eac (Added Class Activity 9)
    }

    // PUT: 更新员工
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,
                                                   @RequestBody Employee updateData) {
<<<<<<< HEAD
        Optional<Employee> employeeOpt = employeeService.getEmployeeById(id);
        if (employeeOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Employee existing = employeeOpt.get();
=======
        Optional<Employee> opt = employeeService.getEmployeeById(id);
        if (opt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Employee existing = opt.get();
>>>>>>> 7843eac (Added Class Activity 9)
        existing.setFirstName(updateData.getFirstName());
        existing.setLastName(updateData.getLastName());
        existing.setEmail(updateData.getEmail());
        existing.setPhone(updateData.getPhone());
        existing.setDepartment(updateData.getDepartment());
        existing.setGender(updateData.getGender());

<<<<<<< HEAD
        Employee updatedEmployee = employeeService.updateEmployee(existing);
        return ResponseEntity.ok(updatedEmployee);
=======
        Employee updated = employeeService.updateEmployee(existing);
        return ResponseEntity.ok(updated);
>>>>>>> 7843eac (Added Class Activity 9)
    }

    // DELETE: 删除员工
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
<<<<<<< HEAD
        Optional<Employee> employeeOpt = employeeService.getEmployeeById(id);
        if (employeeOpt.isEmpty()) {
=======
        Optional<Employee> opt = employeeService.getEmployeeById(id);
        if (opt.isEmpty()) {
>>>>>>> 7843eac (Added Class Activity 9)
            return ResponseEntity.notFound().build();
        }
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
