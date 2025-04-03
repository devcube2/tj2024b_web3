package example.day03._과제3;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {
    private int 학생번호;
    private String 학생명;
    private int 과정번호;

    public StudentEntity toEntity(CourseEntity courseEntity) {
        return StudentEntity.builder()
                .학생번호(학생번호)
                .학생명(학생명)
                .courseEntity(courseEntity)
                .build();
    }
}
