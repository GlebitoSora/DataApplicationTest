package org.example.dataapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RecordService {

    private final RecordRepository recordRepository;

    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    /**
     * Добавление новой записи
     *
     * @param record - объект Record для добавления
     * @return добавленный объект Record
     */
    public Record addRecord(Record record) {
        return recordRepository.save(record);
    }

    /**
     * Получение записи по id
     *
     * @param id - идентификатор записи
     * @return Optional<Record> объект записи
     */
    public Optional<Record> getRecordById(Long id) {
        return recordRepository.findById(id);
    }

    /**
     * Обновление имени записи по id
     *
     * @param id   - идентификатор записи
     * @param name - новое значение имени
     */
    @Transactional
    public void updateRecordName(Long id, String name) {
        recordRepository.updateByName(id, name);
    }

    /**
     * Обновление описания записи по id
     *
     * @param id          - идентификатор записи
     * @param description - новое значение описания
     */
    @Transactional
    public void updateRecordDescription(Long id, String description) {
        recordRepository.updateByDescription(id, description);
    }

    /**
     * Удаление записи по id
     *
     * @param id - идентификатор записи
     */
    public void deleteRecordById(Long id) {
        recordRepository.deleteById(id);
    }
}
