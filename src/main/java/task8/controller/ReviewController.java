package task8.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import task8.model.dto.ReviewDto;
import task8.service.ReviewService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping ("/task8/book/review")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public boolean 리뷰작성(@RequestBody ReviewDto reviewDto) {
        System.out.println("ReviewController.리뷰등록");
        System.out.println("reviewDto = " + reviewDto);
        return reviewService.리뷰작성(reviewDto);
    }

    @GetMapping
    public List<ReviewDto> 책별리뷰전체조회(@RequestParam int bookId) {
        System.out.println("ReviewController.책별리뷰전체조회");
        return reviewService.책별리뷰전체조회(bookId);
    }

    @DeleteMapping
    public boolean 리뷰삭제(@RequestParam int reviewId, @RequestParam String password) {
        System.out.println("ReviewController.리뷰삭제");
        return reviewService.리뷰삭제(reviewId, password);
    }
}
