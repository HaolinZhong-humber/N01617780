package com.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "claims")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @Column(name = "claim_date")
    private String claimDate;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;
}
