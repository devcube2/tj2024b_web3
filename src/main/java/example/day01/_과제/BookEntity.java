package example.day01._과제;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "day02book")
@Data
public class BookEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 생성된값 (mysql 에서 사용시 auto_increment 들어감)
    private int id;
    @Column
    private String name;
    @Column
    private String writer;
    @Column
    private String company;
    @Column
    private String year;
}
