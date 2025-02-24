package com.example.student.repository;

import com.example.student.entity.Enrollment;
import com.example.student.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudent(User student);
    List<Enrollment> findByStudentAndStatus(User student, String status);
} 