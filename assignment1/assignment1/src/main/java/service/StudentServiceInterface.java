package service;

import entity.Student;
import java.util.Collection;

public interface StudentServiceInterface {
    Collection<Student> getAllStudents();
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Long id);
    Student getStudentById(Long id);
}
