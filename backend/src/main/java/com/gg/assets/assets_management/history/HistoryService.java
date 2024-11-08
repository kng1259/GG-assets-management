package com.gg.assets.assets_management.history;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.assets.assets_management.user.User;
import com.gg.assets.assets_management.asset.Asset;

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

    public Long createHisttHistory(User user, Asset asset, String action) {
        History history = new History(user, asset, action);
        historyRepository.save(history);
        return history.getId();
    }

    public Long createHisttHistory(Asset asset, String action) {
        History history = new History(asset, action);
        historyRepository.save(history);
        return history.getId();
    }

}
