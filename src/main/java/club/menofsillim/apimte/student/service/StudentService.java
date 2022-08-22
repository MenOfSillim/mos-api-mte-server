package club.menofsillim.apimte.student.service;

import club.menofsillim.apimte.student.domain.Student;

import java.util.List;

public interface StudentService {
    List<Student> addStudent();
    List<Student> removeStudents();
}
