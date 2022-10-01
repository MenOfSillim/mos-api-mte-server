package club.menofsillim.apimte.contents.student.controller;

import club.menofsillim.apimte.contents.student.domain.Student;
import club.menofsillim.apimte.contents.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@ApiIgnore
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
