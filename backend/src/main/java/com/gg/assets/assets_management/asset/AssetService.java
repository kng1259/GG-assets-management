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
        if (_asset.getName() != null && !_asset.getName().isEmpty()){
            existingAsset.setName(_asset.getName());
        }

        if (_asset.getQuantity() != null && _asset.getQuantity() > 0) {
            existingAsset.setQuantity(_asset.getQuantity());
        }

        if (_asset.getPrice() != null && _asset.getPrice() > 0) {
            existingAsset.setPrice(_asset.getPrice());
        }
        if (_asset.getStatus() != null && !_asset.getStatus().isEmpty()) {
            existingAsset.setStatus(_asset.getStatus());
        }

        assetRepository.save(existingAsset);
        return _asset.getId();
    }
    public Asset getAsset(Long id) {
        return assetRepository.findById(id).orElse(null);}

    public void deleteAsset(Long id) {
        assetRepository.deleteById(id);
    }
    
    public Asset findAssetByID(Long id){
        return assetRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No asset"));
    }
}
