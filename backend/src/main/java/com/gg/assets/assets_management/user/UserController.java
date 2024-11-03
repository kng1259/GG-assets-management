package com.gg.assets.assets_management.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.gg.assets.assets_management.asset.Asset;
import com.gg.assets.assets_management.asset.AssetRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    AssetRepository assetRepository;

    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}/asset")
    public List<Asset> getAssetsByUserId(@PathVariable Long userId) {
        return userService.getAssetsByUserId(userId);
    }

    @PostMapping("/{userId}/asset/post")
    public void addAssetToUser(@PathVariable Long userId, @RequestBody Asset asset) {
        userService.addAssetToUser(userId, asset);
    }
}
