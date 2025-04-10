package example.day04.task4.model.repository;

import example.day04.task4.model.entity.SupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplyRepository extends JpaRepository<SupplyEntity, Integer> {
}
