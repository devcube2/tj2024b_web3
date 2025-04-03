package example.day03._과제3;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseDto {
    private int 과정번호;
    private String 과정명;

    public CourseEntity toEntity() {
        return CourseEntity.builder()
                .과정번호(this.과정번호)
                .과정명(this.과정명)
                .build();
    }
}
