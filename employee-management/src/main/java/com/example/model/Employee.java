package com.example.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @NotNull
    private Long id;

    @NotBlank(message = "First Name cannot be empty")
    @Size(min = 5, max = 20, message = "First Name must be between 5 and 20 characters")
    private String firstName;

    @NotBlank(message = "Last Name cannot be empty")
    private String lastName;

    @Email(message = "Invalid email format")
    private String email;

    private String gender;
}
