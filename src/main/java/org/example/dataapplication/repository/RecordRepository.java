package org.example.dataapplication.repository;

import org.example.dataapplication.entity.Record;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecordRepository extends CrudRepository<org.example.dataapplication.entity.Record, Long> {
    Optional<Record> findById(Long id);

    void deleteById(Long id);
}
