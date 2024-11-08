package com.gg.assets.assets_management.asset;

import java.util.List;

import com.gg.assets.assets_management.department.DepartmentService;
import com.gg.assets.assets_management.history.HistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

import org.springframework.http.HttpStatus;
import com.gg.assets.assets_management.ApiResponse;
import org.springframework.http.ResponseEntity;

@CrossOrigin("*")
@RestController
@RequestMapping("/asset")
public class AssetController {
    @Autowired
    AssetService assetService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    HistoryService historyService;

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<Asset>>> getAllAssets() {
        List<Asset> data = assetService.getAllAssets();
        ApiResponse<List<Asset>> response = new ApiResponse<>(200, "Get asset list success", data);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Long>> createAsset(@RequestBody Asset asset) {
        Long assetId = assetService.createAsset(asset);
        ApiResponse<Long> response = new ApiResponse<Long>(200, "Create asset successfully", assetId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping("/update")
    public ResponseEntity<ApiResponse<Asset>> updateAsset(@RequestBody Asset asset) {
        try {
            if (asset == null
                    || asset.getId() == null
                    || asset.getPrice() <= 0
                    || asset.getQuantity() <= 0
                    || departmentService.getByID(asset.getId()).isEmpty()) {
                ApiResponse<Asset> errorResponse = new ApiResponse<>(400, "Invalid asset data", null);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
            }

            Long assetId = assetService.updateAsset(asset.getId(), asset);
            if (assetId != null) {
                ApiResponse<Asset> response = new ApiResponse<>(200, "Update asset successfully",
                        assetService.getAsset(assetId));
                historyService.createHisttHistory(asset, "Updated");
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                ApiResponse<Asset> notFoundResponse = new ApiResponse<>(404, "Asset not found", null);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundResponse);
            }
        } catch (Exception e) {
            ApiResponse<Asset> errorResponse = new ApiResponse<>(500, "Error updating asset: " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
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
