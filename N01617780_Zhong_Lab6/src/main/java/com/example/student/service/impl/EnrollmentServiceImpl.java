package com.example.student.service.impl;

import com.example.student.constant.SecurityConstants;
import com.example.student.dto.CourseResponse;
import com.example.student.dto.EnrollmentResponse;
import com.example.student.dto.UserResponse;
import com.example.student.entity.Course;
import com.example.student.entity.Enrollment;
import com.example.student.entity.User;
import com.example.student.repository.CourseRepository;
import com.example.student.repository.EnrollmentRepository;
import com.example.student.repository.UserRepository;
import com.example.student.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    @Override
    public List<EnrollmentResponse> getStudentEnrollments(Long studentId) {
        log.info("Fetching enrollments for student ID: {}", studentId);
        User student = userRepository.findById(studentId)
            .orElseThrow(() -> new RuntimeException("Student not found"));
        return enrollmentRepository.findByStudent(student).stream()
            .map(this::convertToResponse)
            .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public EnrollmentResponse enrollCourse(Long studentId, Long courseId) {
        log.info("Enrolling student ID: {} in course ID: {}", studentId, courseId);
        User student = userRepository.findById(studentId)
            .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId)
            .orElseThrow(() -> new RuntimeException("Course not found"));

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setStatus(SecurityConstants.STATUS_ENROLLED);
        
        Enrollment savedEnrollment = enrollmentRepository.save(enrollment);
        log.info("Enrollment successful for student ID: {} in course ID: {}", studentId, courseId);
        return convertToResponse(savedEnrollment);
    }

    @Override
    @Transactional
    public EnrollmentResponse dropCourse(Long studentId, Long courseId) {
        log.info("Dropping course ID: {} for student ID: {}", courseId, studentId);
        User student = userRepository.findById(studentId)
            .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId)
            .orElseThrow(() -> new RuntimeException("Course not found"));

        List<Enrollment> enrollments = enrollmentRepository.findByStudentAndStatus(student, SecurityConstants.STATUS_ENROLLED);
        Enrollment enrollment = enrollments.stream()
            .filter(e -> e.getCourse().getId().equals(courseId))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Enrollment not found"));

        enrollment.setStatus(SecurityConstants.STATUS_DROPPED);
        Enrollment savedEnrollment = enrollmentRepository.save(enrollment);
        log.info("Course dropped successfully for student ID: {} in course ID: {}", studentId, courseId);
        return convertToResponse(savedEnrollment);
    }

    @Override
    public List<EnrollmentResponse> getAllEnrollments() {
        log.info("Fetching all enrollments");
        return enrollmentRepository.findAll().stream()
            .map(this::convertToResponse)
            .collect(Collectors.toList());
    }

    private EnrollmentResponse convertToResponse(Enrollment enrollment) {
        EnrollmentResponse response = new EnrollmentResponse();
        response.setId(enrollment.getId());
        response.setStatus(enrollment.getStatus());
        response.setCreatedDate(enrollment.getCreatedDate());
        response.setModifiedDate(enrollment.getModifiedDate());
        
        // Convert student
        UserResponse studentResponse = new UserResponse();
        studentResponse.setId(enrollment.getStudent().getId());
        studentResponse.setUsername(enrollment.getStudent().getUsername());
        studentResponse.setName(enrollment.getStudent().getName());
        studentResponse.setEmail(enrollment.getStudent().getEmail());
        studentResponse.setAddress(enrollment.getStudent().getAddress());
        studentResponse.setRole(enrollment.getStudent().getRole());
        response.setStudent(studentResponse);
        
        // Convert course
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setId(enrollment.getCourse().getId());
        courseResponse.setCode(enrollment.getCourse().getCode());
        courseResponse.setName(enrollment.getCourse().getName());
        courseResponse.setDescription(enrollment.getCourse().getDescription());
        courseResponse.setCredits(enrollment.getCourse().getCredits());
        response.setCourse(courseResponse);
        
        return response;
    }
} 