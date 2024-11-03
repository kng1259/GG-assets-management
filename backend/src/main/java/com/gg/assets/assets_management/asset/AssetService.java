package com.gg.assets.assets_management.asset;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetService {
    @Autowired
    AssetRepository assetRepository;

    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    public Long createAsset(Asset asset) {
        assetRepository.save(asset);
        return asset.getId();
    }

    public Asset getAsset(Long id) {
        return assetRepository.findById(id).orElse(null);}

    public void deleteAsset(Long id) {
        assetRepository.deleteById(id);
    }

}
