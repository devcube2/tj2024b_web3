package task8.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import task8.model.dto.BookDto;
import task8.model.entity.BookEntity;
import task8.model.repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BookService {
    private final BookRepository bookRepository;
    // 암호화
    private final BCryptPasswordEncoder passwordEncoder;

    public boolean 책추천등록(BookDto bookDto) {
        String encryptPassword = passwordEncoder.encode(bookDto.getPassword());
        bookDto.setPassword(encryptPassword);
        bookRepository.save(bookDto.toEntity());
        return true;
    }

    public List<BookDto> 책추천목록조회() {
        List<BookEntity> bookEntityList = bookRepository.findAll();
        return bookEntityList
                .stream()
                .map(BookEntity::toDto)
                .toList();
    }

    public BookDto 책추천상세조회(int id) {
        BookEntity bookEntity = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("책을 찾을 수 없습니다."));
        return bookEntity.toDto();
    }

    public boolean 책추천수정(BookDto bookDto) {
        BookEntity bookEntity = bookRepository.findById(bookDto.getBookId())
                .orElseThrow(() -> new IllegalArgumentException("책을 찾을 수 없습니다."));
        if ( !passwordEncoder.matches(bookDto.getPassword(), bookEntity.getPassword()) ) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        bookEntity.setTitle(bookDto.getTitle());
        bookEntity.setAuthor(bookDto.getAuthor());
        bookEntity.setDescription(bookDto.getDescription());
        return true;
    }

    public boolean 책추천삭제(int id, String password) {
        BookEntity bookEntity = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("책을 찾을 수 없습니다."));
        if ( !passwordEncoder.matches(password, bookEntity.getPassword()) ) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        bookRepository.deleteById(bookEntity.getBookId());
        return true;
    }
}
