package com.example.student.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    private String password;
    private String role;
    private String name;
    private String email;
    private String address;
    private boolean isActive = true;
    
    @CreationTimestamp
    private LocalDateTime createdDate;
    
    @UpdateTimestamp
    private LocalDateTime modifiedDate;

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments;
} 