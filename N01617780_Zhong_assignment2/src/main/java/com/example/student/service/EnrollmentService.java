package com.example.student.service;

import com.example.student.dto.EnrollmentResponse;
import java.util.List;

public interface EnrollmentService {
    List<EnrollmentResponse> getStudentEnrollments(Long studentId);
    EnrollmentResponse enrollCourse(Long studentId, Long courseId);
    EnrollmentResponse dropCourse(Long studentId, Long courseId);
    List<EnrollmentResponse> getAllEnrollments();
}