package com.example.service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
<<<<<<< HEAD
import com.example.repository.ClaimRepository; // 新增
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional; // 事务管理

=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
>>>>>>> 3d7697b (lab5 submission)
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
<<<<<<< HEAD
    private ClaimRepository claimRepository; // 新增，删除前先处理 claims
=======
    private ClaimRepository claimRepository;
>>>>>>> 3d7697b (lab5 submission)

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void addEmployee(Employee employee) {
        employee.setId(null); // 确保 ID 为空，让数据库自动生成
        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Transactional
    public void deleteEmployee(Long id) {
        // 先删除 claims 表中的相关数据，避免外键约束失败
        claimRepository.deleteByEmployeeId(id);
<<<<<<< HEAD

=======
>>>>>>> 3d7697b (lab5 submission)
        // 然后删除 employee 表中的记录
        employeeRepository.deleteById(id);
    }
}
