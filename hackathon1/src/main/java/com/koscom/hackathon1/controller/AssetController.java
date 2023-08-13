package com.koscom.hackathon1.controller;

import com.koscom.hackathon1.domain.Asset;
import com.koscom.hackathon1.domain.PlaceType;
import com.koscom.hackathon1.request.BuySellRequest;
import com.koscom.hackathon1.response.AssetsResponse;
import com.koscom.hackathon1.service.AssetService;
import com.koscom.hackathon1.service.IPOAssetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetController {
    private final AssetService assetService;

    AssetController(AssetService assetService, IPOAssetService ipoAssetService) {
        this.assetService = assetService;
    }

    @GetMapping("/{assetId}")
    public AssetsResponse getAsset(@PathVariable String assetId) {
        AssetsResponse assetsResponse = new AssetsResponse();
        assetsResponse.setAsset(assetService.findBy(assetId));

        return assetsResponse;
    }

    @GetMapping("/list")
    public AssetsResponse list() {
        AssetsResponse assetsResponse = new AssetsResponse();
        assetsResponse.setAssets(assetService.findAll());

        return assetsResponse;
    }

    @GetMapping("/popular")
    public AssetsResponse popular() {
        AssetsResponse assetsResponse = new AssetsResponse();
        assetsResponse.setAssets(assetService.findPopular());

        return assetsResponse;
    }

    @GetMapping("/{place}")
    public AssetsResponse favoriteList(@PathVariable("place") PlaceType placeType) {
        AssetsResponse assetsResponse = new AssetsResponse();
        assetsResponse.setAssets(assetService.findBy(placeType));

        return assetsResponse;
    }

    @PostMapping("/buy")
    public ResponseEntity<Object> buy(@RequestBody BuySellRequest request) {
        assetService.buy(request.getAssetId(), request.getPrice(), request.getCount(), request.getUserId());

        return ResponseEntity.ok().build();
    }

    @PostMapping("/sell")
    public ResponseEntity<Object> sell(@RequestBody BuySellRequest request) {
        assetService.sell(request.getAssetId(), request.getPrice(), request.getCount(), request.getUserId());

        return ResponseEntity.ok().build();
    }
}
