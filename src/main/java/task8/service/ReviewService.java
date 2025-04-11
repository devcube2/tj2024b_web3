package task8.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import task8.model.dto.ReviewDto;
import task8.model.entity.BookEntity;
import task8.model.entity.ReviewEntity;
import task8.model.repository.BookRepository;
import task8.model.repository.ReviewRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final BookRepository bookRepository;
    // 암호화
    private final BCryptPasswordEncoder passwordEncoder;

    public boolean 리뷰작성(ReviewDto reviewDto) {
        BookEntity bookEntity = bookRepository.findById(reviewDto.getBookId())
                .orElseThrow(() -> new IllegalArgumentException("책을 찾을 수 없습니다."));
        String encryptPassword = passwordEncoder.encode(reviewDto.getPassword());
        reviewDto.setPassword(encryptPassword);
        reviewRepository.save(reviewDto.toEntity(bookEntity));
        return true;
    }

    public boolean 리뷰삭제(int id, String password) {
        ReviewEntity reviewEntity = reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("리뷰를 찾을 수 없습니다."));
        if ( !passwordEncoder.matches(password, reviewEntity.getPassword()) ) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        reviewRepository.deleteById(id);
        return true;
    }

    public List<ReviewDto> 책별리뷰전체조회(int bookId) {
        BookEntity bookEntity = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("책을 찾을 수 없습니다."));
        List<ReviewEntity> reviewEntityList = reviewRepository.findByBookEntity(bookEntity);
        return reviewEntityList
                .stream()
                .map(ReviewEntity::toDto)
                .toList();
    }
}
