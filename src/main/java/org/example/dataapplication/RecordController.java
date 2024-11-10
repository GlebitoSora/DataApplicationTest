package org.example.dataapplication;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public ResponseEntity<Record> createRecord(@RequestBody Record record) {
        Record createdRecord = recordService.addRecord(record);
        return new ResponseEntity<>(createdRecord, HttpStatus.CREATED);
    }

    /**
     * Получение записи по id
     *
     * @param id - идентификатор записи
     * @return объект Record или 404, если запись не найдена
     */
    @GetMapping("/{id}")
    public ResponseEntity<Record> getRecordById(@PathVariable Long id) {
        Optional<Record> record = recordService.getRecordById(id);
        return record.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Обновление имени записи по id
     *
     * @param id - идентификатор записи
     * @param name - новое имя записи
     * @return статус операции
     */
    @PatchMapping("/{id}/name")
    public ResponseEntity<Void> updateRecordName(@PathVariable Long id, @RequestParam String name) {
        recordService.updateRecordName(id, name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Обновление описания записи по id
     *
     * @param id - идентификатор записи
     * @param description - новое описание записи
     * @return статус операции
     */
    @PatchMapping("/{id}/description")
    public ResponseEntity<Void> updateRecordDescription(@PathVariable Long id, @RequestParam String description) {
        recordService.updateRecordDescription(id, description);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Удаление записи по id
     *
     * @param id - идентификатор записи
     * @return статус операции
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecordById(@PathVariable Long id) {
        recordService.deleteRecordById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

