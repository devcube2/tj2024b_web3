package example.day04.task5.model.repository;

import example.day04.task5.model.entity.SupplyEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplyRepository extends JpaRepository<SupplyEntity, Integer> {
    @Modifying
    @Transactional
    @Query (value = "insert into supply (name, description, quantity, created_date, modified_date) values (:name, :description, :quantity, NOW(6), NOW(6))", nativeQuery = true)
    void saveNative(@Param("name") String name, @Param("description") String description, @Param("quantity") int quantity);

    @Query (value = "select * from supply", nativeQuery = true)
    List<SupplyEntity> findAllNative();

    @Query (value = "select * from supply where id = :id", nativeQuery = true)
    SupplyEntity findByIdNative(@Param("id") int id);

    @Modifying
    @Transactional
    @Query (value = "delete from supply where id = :id", nativeQuery = true)
    void deleteByIdNative(@Param("id") int id);
}
