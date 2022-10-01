package club.menofsillim.apimte.contents.student.service;

import club.menofsillim.apimte.contents.student.domain.Student;

import java.util.List;

public interface StudentService {
    List<Student> addStudent();
    List<Student> removeStudents();
}
