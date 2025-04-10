package example.day04.task4.model.entity;

import example.day04.task4.model.dto.SupplyDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "supply")
public class SupplyEntity extends BaseTime {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private int quantity;

    public SupplyDto toDto() {
        return SupplyDto.builder()
                .id(id)
                .name(name)
                .description(description)
                .quantity(quantity)
                .createdDate(createdDate)
                .modifiedDate(modifiedDate)
                .build();
    }
}
