package com.example.student.service.impl;

import com.example.student.dto.CourseResponse;
import com.example.student.entity.Course;
import com.example.student.repository.CourseRepository;
import com.example.student.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public List<CourseResponse> getAllCourses() {
        log.info("Fetching all courses");
        return courseRepository.findAll().stream()
            .map(this::convertToResponse)
            .collect(Collectors.toList());
    }

    @Override
    public CourseResponse getCourse(Long id) {
        log.info("Fetching course with ID: {}", id);
        return courseRepository.findById(id)
            .map(this::convertToResponse)
            .orElseThrow(() -> {
                log.error("Course not found with ID: {}", id);
                return new RuntimeException("Course not found");
            });
    }

    @Override
    @Transactional
    public CourseResponse createCourse(Course course) {
        log.info("Creating new course");
        Course savedCourse = courseRepository.save(course);
        log.info("Course created successfully with ID: {}", savedCourse.getId());
        return convertToResponse(savedCourse);
    }

    @Override
    @Transactional
    public CourseResponse updateCourse(Long id, Course updateData) {
        log.info("Updating course with ID: {}", id);
        return courseRepository.findById(id)
            .map(course -> {
                course.setName(updateData.getName());
                course.setDescription(updateData.getDescription());
                course.setCredits(updateData.getCredits());
                Course savedCourse = courseRepository.save(course);
                log.info("Course updated successfully with ID: {}", id);
                return convertToResponse(savedCourse);
            })
            .orElseThrow(() -> {
                log.error("Course not found with ID: {}", id);
                return new RuntimeException("Course not found");
            });
    }

    @Override
    @Transactional
    public void deleteCourse(Long id) {
        log.info("Deleting course with ID: {}", id);
        courseRepository.deleteById(id);
        log.info("Course deleted successfully with ID: {}", id);
    }

    private CourseResponse convertToResponse(Course course) {
        CourseResponse response = new CourseResponse();
        response.setId(course.getId());
        response.setCode(course.getCode());
        response.setName(course.getName());
        response.setDescription(course.getDescription());
        response.setCredits(course.getCredits());
        return response;
    }
} 