package com.example.repository;

import com.example.model.Employee;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class EmployeeRepository {
    private final Map<Long, Employee> employeeMap = new HashMap<>();
    private Long nextId = 1L;

    public EmployeeRepository() {
        // 预设数据
        employeeMap.put(nextId, new Employee(nextId++, "John", "Doe", "john@example.com", "M"));
        employeeMap.put(nextId, new Employee(nextId++, "Jane", "Smith", "jane@example.com", "F"));
        employeeMap.put(nextId, new Employee(nextId++, "Alice", "Brown", "alice@example.com", "F"));
    }

    public Collection<Employee> getAllEmployees() {
        return employeeMap.values();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return Optional.ofNullable(employeeMap.get(id));
    }

    public void addEmployee(Employee employee) {
        employee.setId(nextId++);
        employeeMap.put(employee.getId(), employee);
    }

    public void updateEmployee(Employee employee) {
        employeeMap.put(employee.getId(), employee);
    }

    public void deleteEmployee(Long id) {
        employeeMap.remove(id);
    }
=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
>>>>>>> 3d7697b (lab5 submission)
}
