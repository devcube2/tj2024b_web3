package example.day01._과제;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/day01/task")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    public boolean 도서등록(@RequestBody BookEntity bookEntity) {
        return bookService.도서등록(bookEntity);
    }

    @GetMapping
    public List<BookEntity> 도서전체조회() {
        return bookService.도서전체조회();
    }

    @PutMapping
    public boolean 도서수정(@RequestBody BookEntity bookEntity) {
        return bookService.도서수정(bookEntity);
    }

    @DeleteMapping
    public boolean 도서삭제(@RequestParam int id) {
        return bookService.도서삭제(id);
    }
}
