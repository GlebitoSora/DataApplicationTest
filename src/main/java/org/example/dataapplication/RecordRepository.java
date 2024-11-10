package org.example.dataapplication;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecordRepository extends CrudRepository<Record, Long> {
    Optional<Record> findById(Long id);

    void deleteById(Long id);
}
