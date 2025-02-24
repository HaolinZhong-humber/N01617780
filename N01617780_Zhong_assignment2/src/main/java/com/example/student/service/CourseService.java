package com.example.student.service;

import com.example.student.dto.CourseResponse;
import com.example.student.entity.Course;
import java.util.List;

public interface CourseService {
    List<CourseResponse> getAllCourses();
    CourseResponse getCourse(Long id);
    CourseResponse createCourse(Course course);
    CourseResponse updateCourse(Long id, Course course);
    void deleteCourse(Long id);
} 