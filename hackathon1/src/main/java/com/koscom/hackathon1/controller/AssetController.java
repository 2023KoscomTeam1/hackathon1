package com.koscom.hackathon1.controller;

import com.koscom.hackathon1.domain.Asset;
import com.koscom.hackathon1.domain.IPOAsset;
import com.koscom.hackathon1.domain.PlaceType;
import com.koscom.hackathon1.service.AssetService;
import com.koscom.hackathon1.service.IPOAssetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetController {
    private final AssetService assetService;

    public AssetController(AssetService assetService, IPOAssetService ipoAssetService) {
        this.assetService = assetService;
    }

    @GetMapping
    public List<Asset> list() {
        return assetService.findAll();
    }

    @GetMapping("/{place}")
    public List<Asset> favoriteList(@PathVariable("place") PlaceType placeType) {
        return assetService.findByPlace(placeType);
    }
}
