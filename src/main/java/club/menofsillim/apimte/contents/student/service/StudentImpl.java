package club.menofsillim.apimte.contents.student.service;

import club.menofsillim.apimte.contents.student.domain.Student;
import club.menofsillim.apimte.contents.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> addStudent() {
        List<Student> students = new ArrayList<>();

        Student student1 = Student.builder().
                studentId("1").name("a").schoolId(1).build();
        Student student2 = Student.builder().
                studentId("1").name("b").schoolId(1).build();

        students.add(student1);
        students.add(student2);

        return studentRepository.saveAll(students);
    }

    @Override
    @Transactional
    public List<Student> removeStudents() {
        return studentRepository.deleteByStudentId("1");
    }
}
