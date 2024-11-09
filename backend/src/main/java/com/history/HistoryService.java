package com.history;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class HistoryService {
    @Autowired
    HistoryRepository historyRepository;

    public History createHisttHistory(History newHistory) {
        return historyRepository.save(newHistory);
    }

    public List<History> getAllHistory() {
        return historyRepository.findAll();
    }

    public Optional<History> getByID(Long id) {
        Optional<History> histById = historyRepository.findById(id);
        return histById;
    }
}
