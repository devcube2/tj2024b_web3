package task8.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task8.model.entity.BookEntity;
import task8.model.entity.ReviewEntity;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {
    List<ReviewEntity> findByBookEntity(BookEntity bookEntity);
}
