package example._과제;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public boolean 도서등록(BookEntity bookEntity) {
        System.out.println("BookService.도서등록");
        bookRepository.save(bookEntity);
        return true;
    }

    public List<BookEntity> 도서전체조회() {
        System.out.println("BookService.도서전체조회");
        return bookRepository.findAll();
    }

    @Transactional
    public boolean 도서수정(BookEntity bookEntity) {
//        System.out.println("BookService.도서수정");
//        bookRepository.save(bookEntity);
//        return true;
        Optional<BookEntity> optionalBookEntity = bookRepository.findById(bookEntity.getId());
        if (optionalBookEntity.isPresent()) {
            BookEntity entity = optionalBookEntity.get();
            entity.setName(bookEntity.getName());
            entity.setWriter(bookEntity.getWriter());
            entity.setCompany(bookEntity.getCompany());
            entity.setYear(bookEntity.getYear());
            return true;
        }
        return false;
    }

    public boolean 도서삭제(int id) {
        System.out.println("BookService.도서삭제");
        bookRepository.deleteById(id);
        return true;
    }
}
