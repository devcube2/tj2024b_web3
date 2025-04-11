package task8.model.dto;

import lombok.Builder;
import lombok.Data;
import task8.model.entity.BookEntity;
import task8.model.entity.ReviewEntity;

@Data
@Builder
public class ReviewDto {
    int reviewId;
    int bookId;
    private String password;
    private String review;

    public ReviewEntity toEntity(BookEntity bookEntity) {
        return ReviewEntity.builder()
                .reviewId(reviewId)
                .bookEntity(bookEntity)
                .password(password)
                .review(review)
                .build();
    }
}
