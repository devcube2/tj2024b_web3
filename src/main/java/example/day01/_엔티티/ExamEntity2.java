package example.day01._엔티티;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity // 해당 클래스를 DB테이블과 매핑 관계 주입 (ORM)
@Table (name = "Exam2") // 테이블명 정의 , 생략시 클래스명으로 정의된다.
public class ExamEntity2 {
    @Id // primary key 제약조건 정의
    @GeneratedValue (strategy = GenerationType.IDENTITY) // 생성된값 (mysql 에서 사용시 auto_increment 들어감)
    private long id;

    @Column (nullable = true , unique = false)
    private String col1;

    @Column (nullable = false , unique = true)
    private String col2;

    @Column (columnDefinition = "longtext")
    private String col3;

    @Column (name = "제품명" , length = 30 , insertable = true , updatable = true) // insertable 은 insert 할때 포함할건지
    private String col4;

    @Column
    private LocalDate col5;

    @Column
    private LocalDateTime col6;
}