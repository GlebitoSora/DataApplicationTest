package org.example.dataapplication;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecordRepository extends CrudRepository<Record, Long> {
    Optional<Record> findById(Long id);

//    @Modifying
//    @Query("UPDATE record SET name = :name WHERE id = :id")
//    void updateByName(@Param("id") Long id, @Param("name") String name);
//
//    @Modifying
//    @Query("UPDATE record SET description = :description WHERE id = :id")
//    void updateByDescription(@Param("id") Long id, @Param("description") String description);

    void deleteById(Long id);
}
