package com.example.student.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EnrollmentResponse {
    private Long id;
    private UserResponse student;
    private CourseResponse course;
    private String status;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
} 