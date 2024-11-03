package com.gg.assets.assets_management.user;

import java.util.List;

import com.gg.assets.assets_management.ApiResponse;
import org.apache.coyote.AbstractProcessor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers() {
        List<User> result = userService.getAllUsers();
        ApiResponse<List<User>> reponse = new ApiResponse<List<User>>(200, "User lists", result );
        return ResponseEntity.status(HttpStatus.OK).body(reponse);
    }

    @GetMapping("/{userId}/asset")
    public ResponseEntity<ApiResponse<List<Asset>>> getAssetsByUserId(@PathVariable Long userId) {
        List<Asset> result = userService.getAssetsByUserId(userId);
        ApiResponse<List<Asset>> reponse = new ApiResponse<>(200, "Assset of user" + userId, result);
        return ResponseEntity.status(HttpStatus.OK).body(reponse);
    }

    @PostMapping("/{userId}/asset/post")
    public ResponseEntity<ApiResponse<Void>> addAssetToUser(@PathVariable Long userId, @RequestBody Asset asset) {
        userService.addAssetToUser(userId, asset);
        ApiResponse<Void> response = new ApiResponse<>(200, "Asset added successfully.", null);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
