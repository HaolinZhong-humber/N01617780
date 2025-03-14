package com.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
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

    @NotBlank(message = "Phone cannot be empty")
    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "department")
    private String department;

    @Column(name = "gender")
    private String gender;

    // Getter and Setter 方法
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
}
