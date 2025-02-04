package service;

import entity.Student;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StudentService implements StudentServiceInterface {
    private final Map<Long, Student> studentMap = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(3); // 现有 3 个学生，ID 从 4 开始

    public StudentService() {
        studentMap.put(1L, new Student(1L, "John Doe", 20, "M", "john@example.com", "Toronto", java.time.LocalDate.of(2004, 5, 10)));
        studentMap.put(2L, new Student(2L, "Jane Smith", 22, "F", "jane@example.com", "Vancouver", java.time.LocalDate.of(2002, 8, 15)));
        studentMap.put(3L, new Student(3L, "Alice Brown", 19, "F", "alice@example.com", "Montreal", java.time.LocalDate.of(2005, 3, 20)));
    }

    @Override
    public Collection<Student> getAllStudents() {
        return studentMap.values();
    }

    @Override
    public void addStudent(Student student) {
        long newId = idGenerator.incrementAndGet(); // 生成唯一 ID
        student.setId(newId);
        studentMap.put(newId, student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentMap.remove(id);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentMap.get(id);
    }

    @Override
    public void updateStudent(Student updatedStudent) {
        studentMap.put(updatedStudent.getId(), updatedStudent);
    }
}
