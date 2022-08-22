package club.menofsillim.apimte.student.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Getter
@ToString
@Entity
@Table(name = "student")
@IdClass(StudentID.class)
public class Student implements Serializable {
    @Id
    @Column(name = "student_id")
    private String studentId;

    @Id
    private String name;

    @Column(name = "school_id")
    private int schoolId;
    private int score;

    @Builder
    public Student(String studentId, String name, int schoolId, int score) {
        this.studentId = studentId;
        this.name = name;
        this.schoolId = schoolId;
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Student student = (Student) o;
        return studentId != null && Objects.equals(studentId, student.studentId)
                && name != null && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, name);
    }
}
