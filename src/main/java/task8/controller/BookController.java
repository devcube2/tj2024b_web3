package task8.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import task8.model.dto.BookDto;
import task8.service.BookService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping ("/task8/book")
public class BookController {
    private final BookService bookService;

    @PostMapping
    public boolean 책추천등록(@RequestBody BookDto bookDto) {
        System.out.println("BookController.책추천등록");
        System.out.println("bookDto = " + bookDto);
        return bookService.책추천등록(bookDto);
    }

    @GetMapping
    public List<BookDto> 책추천목록조회() {
        System.out.println("BookController.책추천목록조회");
        return bookService.책추천목록조회();
    }

    @GetMapping ("/view")
    public BookDto 책추천상세조회(@RequestParam int id) {
        System.out.println("BookController.책추천상세조회");
        return bookService.책추천상세조회(id);
    }

    @PutMapping
    public boolean 책추천수정(@RequestBody BookDto bookDto) {
        System.out.println("BookController.책추천수정");
        System.out.println("bookDto = " + bookDto);
        return bookService.책추천수정(bookDto);
    }

    @DeleteMapping
    public boolean 책추천삭제(@RequestParam int id, @RequestParam String password) {
        System.out.println("BookController.책추천삭제");
        System.out.println("id = " + id + ", password = " + password);
        return bookService.책추천삭제(id, password);
    }
}
