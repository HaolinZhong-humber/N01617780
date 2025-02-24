# Student Record Management System

A Spring Boot application for managing student records, course enrollments, and administrative tasks.

## Features

### Student Features
- Login and authentication
- View and update personal information
- View available courses
- Enroll in courses
- Drop enrolled courses
- Track enrollment history

### Admin Features
- Manage student accounts
- View all student enrollments
- Perform CRUD operations on courses
- Soft delete functionality for student records

## Technical Stack

- Spring Boot 3.x
- Spring Security
- Spring Data JPA
- MySQL Database
- Thymeleaf Templates
- Bootstrap 5
- Lombok
- SLF4J Logging

## Getting Started

### Prerequisites
- Java 17 or higher
- MySQL 8.0 or higher
- Maven 3.x

### Database Setup
1. Create a MySQL database named `j2ee`
2. Update database credentials in `application.properties` if needed

### Running the Application
1. Clone the repository
2. Navigate to the project directory
3. Run: `mvn spring-boot:run`
4. Access the application at: `http://localhost:8080`

### Test Accounts

Admin Account:
- Username: admin
- Password: admin123

Student Accounts:
- Username: john
- Password: john123

## Project Structure

- `src/main/java/com/example/student/` - Source code
- `src/main/resources/` - Configuration files and templates
- `src/main/resources/templates/` - Thymeleaf templates
- `src/main/resources/data.sql` - Database initialization script

## Features Implementation

- User authentication and authorization using Spring Security
- Database operations using Spring Data JPA
- Soft delete implementation for data integrity
- Audit logging for all operations
- Responsive UI using Bootstrap 