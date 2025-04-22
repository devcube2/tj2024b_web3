package web.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity@Table(name ="reply")
@Data@Builder
@NoArgsConstructor@AllArgsConstructor
public class ReplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rno;

    @Column (nullable = false)
    private String rcontent;

    @ManyToOne
    @JoinColumn (name = "mno")
    private MemberEntity memberEntity;

    @ManyToOne
    @JoinColumn (name = "pno")
    private ProductEntity productEntity;
}
