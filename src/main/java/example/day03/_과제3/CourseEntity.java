package example.day03._과제3;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "course")
public class CourseEntity extends BaseTime {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int 과정번호;
    @Column (nullable = false)
    private String 과정명;

    @ToString.Exclude // 순환참조 방지
    @Builder.Default // 빌더패턴 사용시 초기값 대입
    @OneToMany (mappedBy = "courseEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<StudentEntity> studentEntityList = new ArrayList<>();

    public CourseDto toDto() {
        return CourseDto.builder()
                .과정번호(과정번호)
                .과정명(과정명)
                .build();
    }
}
