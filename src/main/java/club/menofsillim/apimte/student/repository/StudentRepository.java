package club.menofsillim.apimte.student.repository;

import club.menofsillim.apimte.student.domain.Student;
import club.menofsillim.apimte.student.domain.StudentID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, StudentID> {
    List<Student> deleteByStudentId(String studentId);
//    List<Student> (String studentId);
}
