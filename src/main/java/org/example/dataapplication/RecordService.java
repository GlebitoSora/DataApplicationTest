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
     * Полное обновление записи по id
     *
     * @param id            - идентификатор записи
     * @param updatedRecord - объект Records с новыми данными
     * @return true, если запись была обновлена, иначе false
     */
    public boolean updateRecord(Long id, Record updatedRecord) {
        Optional<Record> existingRecordOpt = recordRepository.findById(id);
        if (existingRecordOpt.isPresent()) {
            Record existingRecord = existingRecordOpt.get();
            existingRecord.setName(updatedRecord.getName());
            existingRecord.setDescription(updatedRecord.getDescription());
            recordRepository.save(existingRecord);
            return true;
        } else {
            return false;
        }
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
