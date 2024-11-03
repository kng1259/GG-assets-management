package com.gg.assets.assets_management.user;

import java.util.List;
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

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Asset> getAssetsByUserId(Long userId) {
        Long departmentId = userRepository.findById(userId).orElseThrow().getDepartment().getId();
        return assetRepository.findByDepartmentId(departmentId);
    }
}
