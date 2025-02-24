package com.example.student.controller;

import com.example.student.dto.CourseResponse;
import com.example.student.dto.EnrollmentResponse;
import com.example.student.dto.UserResponse;
import com.example.student.entity.Course;
import com.example.student.entity.User;
import com.example.student.service.CourseService;
import com.example.student.service.EnrollmentService;
import com.example.student.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;
    private final CourseService courseService;
    private final EnrollmentService enrollmentService;

    @GetMapping("/students")
    @ResponseBody
    public List<UserResponse> getAllStudents() {
        return userService.getAllStudents();
    }

    @PostMapping(value = "/students", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String createStudent(User student) {
        userService.createStudent(student);
        return "redirect:/admin/students";
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        userService.deleteStudent(id);
        return "redirect:/admin/students";
    }

    @GetMapping("/courses")
    @ResponseBody
    public List<CourseResponse> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping(value = "/courses", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String createCourse(Course course) {
        courseService.createCourse(course);
        return "redirect:/admin/courses";
    }

    @PutMapping(value = "/courses/{id}", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String updateCourse(@PathVariable("id") Long id, Course course) {
        courseService.updateCourse(id, course);
        return "redirect:/admin/courses";
    }

    @DeleteMapping("/courses/{id}")
    public String deleteCourse(@PathVariable("id") Long id) {
        courseService.deleteCourse(id);
        return "redirect:/admin/courses";
    }

    @GetMapping("/enrollments")
    @ResponseBody
    public List<EnrollmentResponse> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }
} 