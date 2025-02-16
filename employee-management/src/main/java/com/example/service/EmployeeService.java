package com.example.service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
<<<<<<< HEAD
import org.springframework.stereotype.Service;

import java.util.Collection;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
>>>>>>> 3d7697b (lab5 submission)
import java.util.Optional;

@Service
public class EmployeeService {
<<<<<<< HEAD
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;

        // **只有当数据为空时，才初始化默认员工**
        if (employeeRepository.getAllEmployees().isEmpty()) {
            employeeRepository.addEmployee(new Employee(null, "John", "Doe", "john@example.com", "M"));
            employeeRepository.addEmployee(new Employee(null, "Jane", "Smith", "jane@example.com", "F"));
            employeeRepository.addEmployee(new Employee(null, "Alice", "Brown", "alice@example.com", "F"));
        }
    }

    public Collection<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.getEmployeeById(id);
    }

    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.updateEmployee(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployee(id);
=======

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
>>>>>>> 3d7697b (lab5 submission)
    }
}
