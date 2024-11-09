package com.gg.assets.assets_management.history;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {
    @Autowired
    HistoryRepository historyRepository;

    public Long createHisttHistory(History newHistory) {
        historyRepository.save(newHistory);
        return newHistory.getId();
    }

    public List<History> getAllHistory() {
        return historyRepository.findAll();
    }

    public Optional<History> getByID(Long id) {
        Optional<History> histById = historyRepository.findById(id);
        return histById;
    }

    public History create(History newHist) {
        return historyRepository.save(newHist);
    }
}
