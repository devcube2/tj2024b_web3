package task8.model.entity;

import jakarta.persistence.*;
import lombok.*;
import task8.model.dto.ReviewDto;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book_review")
public class ReviewEntity extends BaseTime {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int reviewId;
    @Column
    private String password;
    @Column
    private String review;

    @ManyToOne
    @JoinColumn(name = "bookId")
    private BookEntity bookEntity;

    public ReviewDto toDto() {
        return ReviewDto.builder()
                .reviewId(reviewId)
                .bookId(bookEntity.getBookId())
                .password(password)
                .review(review)
                .build();
    }
}
