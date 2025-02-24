-- Drop tables if they exist
DROP TABLE IF EXISTS enrollments;
DROP TABLE IF EXISTS courses;
DROP TABLE IF EXISTS users;

-- Create users table
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    role VARCHAR(20) NOT NULL,  -- ROLE_STUDENT or ROLE_ADMIN
    name VARCHAR(100),
    email VARCHAR(100),
    address TEXT,
    is_active BOOLEAN DEFAULT TRUE,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create courses table
CREATE TABLE courses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(20) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    credits INT NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create enrollments table
CREATE TABLE enrollments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    student_id BIGINT NOT NULL,
    course_id BIGINT NOT NULL,
    status VARCHAR(20) NOT NULL, -- ENROLLED, DROPPED
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES users(id),
    FOREIGN KEY (course_id) REFERENCES courses(id)
);

-- Insert test data: Admin user (password: admin123)
INSERT INTO users (username, password, role, name, email) 
VALUES ('admin', 'admin123', 'ROLE_ADMIN', 'System Admin', 'admin@example.com');

-- Insert test data: Student users
INSERT INTO users (username, password, role, name, email, address) VALUES
('john', 'john123', 'ROLE_STUDENT', 'John Smith', 'john@example.com', '123 Student St, City'),
('mary', 'mary123', 'ROLE_STUDENT', 'Mary Johnson', 'mary@example.com', '456 College Ave, City'),
('peter', 'peter123', 'ROLE_STUDENT', 'Peter Brown', 'peter@example.com', '789 University Blvd, City');

-- Insert test data: Courses
INSERT INTO courses (code, name, description, credits) VALUES
('CS101', 'Introduction to Programming', 'Basic programming concepts using Java', 3),
('CS201', 'Data Structures', 'Advanced data structures and algorithms', 4),
('CS301', 'Database Systems', 'Introduction to database design and SQL', 3),
('CS401', 'Web Development', 'Full-stack web application development', 4),
('CS501', 'Artificial Intelligence', 'Basic concepts of AI and machine learning', 4);

-- Insert test data: Enrollments
INSERT INTO enrollments (student_id, course_id, status) VALUES
(2, 1, 'ENROLLED'),  -- John enrolled in CS101
(2, 2, 'ENROLLED'),  -- John enrolled in CS201
(3, 1, 'ENROLLED'),  -- Mary enrolled in CS101
(3, 3, 'DROPPED'),   -- Mary dropped CS301
(4, 2, 'ENROLLED'),  -- Peter enrolled in CS201
(4, 4, 'ENROLLED');  -- Peter enrolled in CS401 