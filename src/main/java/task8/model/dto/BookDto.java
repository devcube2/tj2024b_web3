package task8.model.dto;

import lombok.Builder;
import lombok.Data;
import task8.model.entity.BookEntity;

@Data
@Builder
public class BookDto {
    private int bookId;
    private String password;
    private String title;
    private String author;
    private String description;

    public BookEntity toEntity() {
        return BookEntity.builder()
                .bookId(bookId)
                .password(password)
                .title(title)
                .author(author)
                .description(description)
                .build();
    }
}
