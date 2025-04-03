package example.day01.리포지토리;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "student1")
@Data
public class ExamEntity {
    // 1. 학번
    @Id
    private String id;

    // 2. 이름
    @Column (nullable = false)
    private String name;

    // 3. 국어점수
    @Column
    private int kor;

    // 4. 영어점수
    @Column
    private int eng;
}
