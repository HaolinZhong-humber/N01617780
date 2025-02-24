package com.example.student.controller;

import com.example.student.dto.CourseResponse;
import com.example.student.dto.EnrollmentResponse;
import com.example.student.dto.UserResponse;
import com.example.student.entity.User;
import com.example.student.service.CourseService;
import com.example.student.service.EnrollmentService;
import com.example.student.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {
    private final UserService userService;
    private final CourseService courseService;
    private final EnrollmentService enrollmentService;

    @GetMapping("/profile")
    @ResponseBody
    public UserResponse getProfile(Authentication authentication) {
        return userService.getStudent(Long.parseLong(authentication.getName()));
    }

    @PutMapping(value = "/profile", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String updateProfile(Authentication authentication, User user) {
        userService.updateProfile(Long.parseLong(authentication.getName()), user);
        return "redirect:/student/profile";
    }

    @PostMapping("/courses/{courseId}/enroll")
    public String enrollCourse(Authentication authentication, @PathVariable("courseId") Long courseId) {
        enrollmentService.enrollCourse(Long.parseLong(authentication.getName()), courseId);
        return "redirect:/student/courses";
    }

    @PostMapping("/courses/{courseId}/drop")
    public String dropCourse(Authentication authentication, @PathVariable("courseId") Long courseId) {
        enrollmentService.dropCourse(Long.parseLong(authentication.getName()), courseId);
        return "redirect:/student/enrollments";
    }

    @GetMapping("/courses")
    @ResponseBody
    public List<CourseResponse> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/enrollments")
    @ResponseBody
    public List<EnrollmentResponse> getMyEnrollments(Authentication authentication) {
        return enrollmentService.getStudentEnrollments(Long.parseLong(authentication.getName()));
    }
} 