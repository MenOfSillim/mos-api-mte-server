package club.menofsillim.apimte.contents.student.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentID implements Serializable {
    private String studentId;
    private String name;
}
