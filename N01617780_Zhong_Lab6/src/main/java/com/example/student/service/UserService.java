package com.example.student.service;

import com.example.student.dto.LoginRequest;
import com.example.student.dto.UserResponse;
import com.example.student.entity.User;

import java.util.List;

public interface UserService {
    UserResponse login(LoginRequest request);
    UserResponse updateProfile(Long userId, User user);
    List<UserResponse> getAllStudents();
    UserResponse getStudent(Long id);
    void deleteStudent(Long id);
    UserResponse createStudent(User user);
} 