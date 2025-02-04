package controller;

import entity.Student;
import service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/students", produces = "text/html")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "index";
    }

    @GetMapping("/add")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "addStudent";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        studentService.addStudent(student);
        return "redirect:/students";
    }

    // 🔥 删除学生
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    // 🔥 显示编辑页面
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return "redirect:/students"; // 防止 ID 无效时报错
        }
        model.addAttribute("student", student);
        return "editStudent";
    }


    // 🔥 更新学生信息
    @PostMapping("/update")
    public String updateStudent(@ModelAttribute Student student) {
        studentService.updateStudent(student);
        return "redirect:/students";
    }
}
