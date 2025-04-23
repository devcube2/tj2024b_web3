package web.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "category")
@Data@Builder
@NoArgsConstructor@AllArgsConstructor
public class CategoryEntity extends BaseTime {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long cno; // 카테고리 식별번호

    @Column (nullable = false, length=100)
    private String cname; // 카레고리 이름

    @OneToMany (mappedBy = "categoryEntity", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @ToString.Exclude // 양방향 설계시 toString 롬북의 순환참조 방지
    @Builder.Default // 엔티티 객체 생성시 빌더메소드 사용하면 기본값
    private List<ProductEntity> ProductEntityList = new ArrayList<>();
}
