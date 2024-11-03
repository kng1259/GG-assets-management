package com.gg.assets.assets_management.asset;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

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

    public Long updateAsset(Long id, Asset _asset) {
        Optional<Asset> optionalAsset = assetRepository.findById(id);

        Asset existingAsset = optionalAsset.get();

        existingAsset.setName(_asset.getName());
        existingAsset.setQuantity(_asset.getQuantity());
        existingAsset.setPrice(_asset.getPrice());
        existingAsset.setStatus(_asset.getStatus());
        existingAsset.setDepartId(_asset.getDepartId());

        assetRepository.save(existingAsset);
        return _asset.getId();
    }
}
