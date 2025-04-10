package example.day04.task5.model.repository;

import example.day04.task5.model.entity.SupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplyRepository extends JpaRepository<SupplyEntity, Integer> {
    @Modifying
    @Query (value = "insert into supply (name, description, quantity) values (:name, :description, :quantity)")
    boolean saveNative(String name, String description, int quantity);

    @Query (value = "select * from supply", nativeQuery = true)
    List<SupplyEntity> findAllNative();

    @Query (value = "select * from supply where id = :id", nativeQuery = true)
    SupplyEntity findByIdNative(int id);

    @Modifying
    @Query (value = "delete from supply where id = :id", nativeQuery = true)
    boolean deleteByIdNative(int id);
}
