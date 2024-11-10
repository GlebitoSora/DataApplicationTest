package org.example.dataapplication.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.dataapplication.service.RecordService;
import org.example.dataapplication.entity.Record;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/records")
public class RecordController {

    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    /**
     * Создание новой записи
     *
     * @param record - данные записи
     * @return созданный объект Record
     */
    @PostMapping
    public ResponseEntity<org.example.dataapplication.entity.Record> createRecord(@RequestBody org.example.dataapplication.entity.Record record) {
        log.info("Create record: {}", record);
        return ResponseEntity.ok(recordService.addRecord(record));
    }

    /**
     * Получение записи по id
     *
     * @param id - идентификатор записи
     * @return объект Record или 404, если запись не найдена
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getRecordById(@PathVariable Long id) {
        log.info("Get record by id: {}", id);
        return ResponseEntity.ok(recordService.getRecordById(id));
    }

    /**
     * Обновление всех данных записи по id
     *
     * @param id            - идентификатор записи
     * @param updatedRecord - объект Records с обновленными данными
     * @return статус операции
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateRecord(@PathVariable Long id, @RequestBody Record updatedRecord) {
        log.info("Update record: {}", updatedRecord);
        return ResponseEntity.ok(recordService.updateRecord(id, updatedRecord));
    }

    /**
     * Удаление записи по id
     *
     * @param id - идентификатор записи
     */
    @DeleteMapping("/{id}")
    public void deleteRecordById(@PathVariable Long id) {
        log.info("Delete record by id: {}", id);
        recordService.deleteRecordById(id);
    }
}

