package com.example.repository;

import com.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
<<<<<<< HEAD
    // 可添加自定义查询方法
=======
    // 可以添加自定义查询方法
>>>>>>> 7843eac (Added Class Activity 9)
}
