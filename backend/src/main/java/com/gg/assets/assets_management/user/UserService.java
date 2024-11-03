package com.gg.assets.assets_management.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.assets.assets_management.asset.Asset;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Asset> getAssetsByUserId(Long userId) {
        return userRepository.findById(userId).orElseThrow().getDepartment().getAssets();
    }
}
