package com.gg.assets.assets_management.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.assets.assets_management.asset.Asset;
import com.gg.assets.assets_management.asset.AssetRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AssetRepository assetRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User không tồn tại"));
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Asset> getAssetsByUserId(Long userId) {
        return userRepository.findById(userId).orElseThrow().getDepartment().getAssets();
    }

    public void addAssetToUser(Long userId, Asset asset) {
        User user = userRepository.findById(userId).orElseThrow();
        asset.setDepartment(user.getDepartment());
        assetRepository.save(asset);
        user.getDepartment().getAssets().add(asset);
        userRepository.save(user);
    }
}
