package com.example.student.dto;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String username;
    private String name;
    private String email;
    private String address;
    private String role;
} 