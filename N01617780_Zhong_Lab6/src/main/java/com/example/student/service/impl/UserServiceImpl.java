package com.example.student.service.impl;

import com.example.student.constant.SecurityConstants;
import com.example.student.dto.LoginRequest;
import com.example.student.dto.UserResponse;
import com.example.student.entity.User;
import com.example.student.repository.UserRepository;
import com.example.student.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse login(LoginRequest request) {
        log.info("Attempting login for user: {}", request.getUsername());
        return userRepository.findByUsernameAndIsActiveTrue(request.getUsername())
            .filter(user -> passwordEncoder.matches(request.getPassword(), user.getPassword()))
            .map(this::convertToResponse)
            .orElseThrow(() -> {
                log.error("Invalid credentials for user: {}", request.getUsername());
                return new RuntimeException("Invalid credentials");
            });
    }

    @Override
    @Transactional
    public UserResponse updateProfile(Long userId, User updateData) {
        log.info("Updating profile for user ID: {}", userId);
        return userRepository.findById(userId)
            .map(user -> {
                user.setName(updateData.getName());
                user.setEmail(updateData.getEmail());
                user.setAddress(updateData.getAddress());
                User savedUser = userRepository.save(user);
                log.info("Profile updated successfully for user ID: {}", userId);
                return convertToResponse(savedUser);
            })
            .orElseThrow(() -> {
                log.error("User not found with ID: {}", userId);
                return new RuntimeException("User not found");
            });
    }

    @Override
    public List<UserResponse> getAllStudents() {
        log.info("Fetching all students");
        return userRepository.findAll().stream()
            .filter(user -> SecurityConstants.ROLE_STUDENT.equals(user.getRole()))
            .map(this::convertToResponse)
            .collect(Collectors.toList());
    }

    @Override
    public UserResponse getStudent(Long id) {
        log.info("Fetching student with ID: {}", id);
        return userRepository.findById(id)
            .map(this::convertToResponse)
            .orElseThrow(() -> {
                log.error("Student not found with ID: {}", id);
                return new RuntimeException("Student not found");
            });
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        log.info("Soft deleting student with ID: {}", id);
        userRepository.findById(id)
            .ifPresent(user -> {
                user.setActive(false);
                userRepository.save(user);
                log.info("Student soft deleted successfully, ID: {}", id);
            });
    }

    @Override
    @Transactional
    public UserResponse createStudent(User user) {
        log.info("Creating new student");
        user.setPassword(user.getPassword());
        user.setRole(SecurityConstants.ROLE_STUDENT);
        User savedUser = userRepository.save(user);
        log.info("Student created successfully with ID: {}", savedUser.getId());
        return convertToResponse(savedUser);
    }

    private UserResponse convertToResponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setAddress(user.getAddress());
        response.setRole(user.getRole());
        return response;
    }
} 