package web.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.model.entity.ImageEntity;

@Repository
public interface ImageRepository extends JpaRepository <ImageEntity, Long> {
}
