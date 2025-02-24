package com.example.student.controller;

import com.example.student.service.CourseService;
import com.example.student.service.EnrollmentService;
import com.example.student.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ViewController {
    private final CourseService courseService;
    private final EnrollmentService enrollmentService;
    private final UserService userService;
    
    @GetMapping("/")
    public String home(Authentication auth) {
        if (auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/admin/students";
        }
        return "redirect:/student/courses";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/student/courses")
    public String studentCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "student/courses";
    }
    
    @GetMapping("/student/enrollments")
    public String studentEnrollments(Authentication authentication, Model model) {
        Long studentId = Long.parseLong(authentication.getName());
        model.addAttribute("enrollments", enrollmentService.getStudentEnrollments(studentId));
        return "student/enrollments";
    }
    
    @GetMapping("/admin/students")
    public String adminStudents(Model model) {
        model.addAttribute("students", userService.getAllStudents());
        return "admin/students";
    }
    
    @GetMapping("/admin/courses")
    public String adminCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "admin/courses";
    }
} 