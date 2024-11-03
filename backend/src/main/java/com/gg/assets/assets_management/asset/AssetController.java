package com.gg.assets.assets_management.asset;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.gg.assets.assets_management.ApiResponse;
import org.springframework.http.ResponseEntity;

@CrossOrigin("*")
@RestController
@RequestMapping("/asset")
public class AssetController {
    @Autowired
    AssetService assetService;

    @GetMapping("")
    public List<Asset> getAllAssets() {
        return assetService.getAllAssets();
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Long>> createAsset(@RequestBody Asset asset) {
        Long assetId = assetService.createAsset(asset);
        ApiResponse<Long> response = new ApiResponse<Long>(200,"Create asset successfully", assetId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    
    @PostMapping("/update")
    public ResponseEntity<ApiResponse<Long>> updateAsset(@RequestBody Asset asset) {
        Long assetId = assetService.updateAsset(asset.getId(), asset);
        ApiResponse<Long> response = new ApiResponse<Long>(200,"Update asset successfully", assetId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
