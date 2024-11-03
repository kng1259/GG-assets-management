package com.gg.assets.assets_management.asset;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public Asset createAsset(@RequestBody Asset asset) {
        System.out.println(asset);
        assetService.createAsset(asset);
        return asset;
    }

    @GetMapping("/asset/{id}")
    public Asset getAsset(@PathVariable Long id){
        return assetService.getAsset(id);
    }
}
