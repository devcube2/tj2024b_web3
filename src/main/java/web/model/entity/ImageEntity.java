package web.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity@Table(name ="img")
@Data@Builder
@NoArgsConstructor@AllArgsConstructor
public class ImageEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ino;

    @Column (nullable = false)
    private String iname;

    @ManyToOne
    @JoinColumn (name = "pno")
    private ProductEntity productEntity;
}
