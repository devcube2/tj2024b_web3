package web.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "product")
@Data@Builder
@NoArgsConstructor@AllArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pno; // 제품 식별번호

    @Column (nullable = false)
    private String pname; // 제품명

    @Column (columnDefinition = "longtext") // mysql 네이티브 타입
    private String pcontent; // 제품설명

    @Column
    @ColumnDefault("0")
    private int pprice; // 제품가격

    @Column
    @ColumnDefault("0")
    private int pview; // 조회수

    // * 단방향 : 참조할 PK필드가 존재하는 엔티티 필드 생성
    @ManyToOne
    @JoinColumn (name = "mno") // fk 필드명 정의
    private MemberEntity memberEntity;

    @ManyToOne
    @JoinColumn (name = "cno") // fk 필드명 정의
    private CategoryEntity categoryEntity;

    @OneToMany (mappedBy = "productEntity", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @ToString.Exclude // 양방향 설계시 toString 롬북의 순환참조 방지
    @Builder.Default // 엔티티 객체 생성시 빌더메소드 사용하면 기본값
    private List<ImageEntity> ImageEntityList = new ArrayList<>();

    @OneToMany (mappedBy = "productEntity", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @ToString.Exclude // 양방향 설계시 toString 롬북의 순환참조 방지
    @Builder.Default // 엔티티 객체 생성시 빌더메소드 사용하면 기본값
    private List<ReplyEntity> replyEntityList = new ArrayList<>();
}
