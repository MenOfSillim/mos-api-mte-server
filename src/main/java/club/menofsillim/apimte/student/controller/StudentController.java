package club.menofsillim.apimte.student.controller;

import club.menofsillim.apimte.student.domain.Student;
import club.menofsillim.apimte.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public List<Student> saveStudents() {
        return studentService.addStudent();
    }

    @GetMapping("/students/1")
    public List<Student> deleteStudents() {
        return studentService.removeStudents();
    }
}
