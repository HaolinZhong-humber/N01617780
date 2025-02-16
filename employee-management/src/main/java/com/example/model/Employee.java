package com.example.model;

<<<<<<< HEAD
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

=======
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First Name cannot be empty")
    @Size(min = 2, max = 20, message = "First Name must be between 2 and 20 characters")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Last Name cannot be empty")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Email
    @NotBlank(message = "Email cannot be empty")
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "department")
    private String department;

    @Column(name = "gender")
>>>>>>> 3d7697b (lab5 submission)
    private String gender;
}
