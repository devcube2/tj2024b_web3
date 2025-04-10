package example.day04.task5.model.dto;

import example.day04.task5.model.entity.SupplyEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SupplyDto {
    private int id;
    private String name;
    private String description;
    private int quantity;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public SupplyEntity toEntity() {
        return SupplyEntity.builder()
                .id(id)
                .name(name)
                .description(description)
                .quantity(quantity)
                .build();
    }
}
