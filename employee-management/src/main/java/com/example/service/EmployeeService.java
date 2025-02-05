package com.example.service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class EmployeeService {
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
    }
}
