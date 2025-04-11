package task8.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task8.model.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
}
