package example.day03._과제3;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "student")
public class StudentEntity extends BaseTime {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int 학생번호;
    @Column (nullable = false)
    private String 학생명;
    @ManyToOne
    private CourseEntity courseEntity;

    public StudentDto toDto() {
        return StudentDto.builder()
                .학생번호(학생번호)
                .학생명(학생명)
                .과정번호(courseEntity.get과정번호())
                .build();
    }
}
