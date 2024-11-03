package com.gg.assets.assets_management.asset;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<ApiResponse<List<Asset>>> getAllAssets() {
        List<Asset> data = assetService.getAllAssets();
        ApiResponse<List<Asset>> response = new ApiResponse<>(200,"Get asset list success", data );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/create")
    public Asset createAsset(@RequestBody Asset asset) {
        System.out.println(asset);
        assetService.createAsset(asset);
        return asset;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Asset>> getAsset(@PathVariable Long id) {
        Asset data = assetService.getAsset(id);
        System.out.println(id);

        if (data == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(404, "Asset not found", null));
        }

        ApiResponse<Asset> response = new ApiResponse<>(200, "Get asset success", data);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteAsset(@PathVariable Long id) {
        Asset data = assetService.getAsset(id);

        if (data == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(404, "Asset not found", null));
        }

        assetService.deleteAsset(id);
        ApiResponse<Void> response = new ApiResponse<>(200, "Delete asset success", null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
