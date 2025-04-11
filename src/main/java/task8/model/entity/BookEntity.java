package task8.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import task8.model.dto.BookDto;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "book")
public class BookEntity extends BaseTime {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int bookId;
    @Column
    private String password;
    @Column
    private String title;
    @Column
    private String author;
    @Column
    private String description;

    public BookDto toDto() {
        return BookDto.builder()
                .bookId(bookId)
                .password(password)
                .title(title)
                .author(author)
                .description(description)
                .build();
    }
}
