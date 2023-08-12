package com.koscom.hackathon1.controller;

import com.koscom.hackathon1.domain.Asset;
import com.koscom.hackathon1.domain.PlaceType;
import com.koscom.hackathon1.request.BuySellRequest;
import com.koscom.hackathon1.service.AssetService;
import com.koscom.hackathon1.service.IPOAssetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetController {
    private final AssetService assetService;

    public AssetController(AssetService assetService, IPOAssetService ipoAssetService) {
        this.assetService = assetService;
    }

    @GetMapping("/{assetId}")
    public Asset getAsset(@PathVariable String assetId) {
        return assetService.findBy(assetId);
    }

    @GetMapping("/list")
    public List<Asset> list() {
        return assetService.findAll();
    }

    @GetMapping("/popular")
    public List<Asset> popular() {
        return assetService.findPopular();
    }

    @GetMapping("/{place}")
    public List<Asset> favoriteList(@PathVariable("place") PlaceType placeType) {
        return assetService.findBy(placeType);
    }
}
