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

    AssetController(AssetService assetService, IPOAssetService ipoAssetService) {
        this.assetService = assetService;
    }

    @GetMapping("/{assetId}")
    public ResponseEntity<Asset> getAsset(@PathVariable String assetId) {
        return ResponseEntity.ok(assetService.findBy(assetId));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Asset>> list() {
        return ResponseEntity.ok(assetService.findAll());
    }

    @GetMapping("/popular")
    public ResponseEntity<List<Asset>> popular() {
        return ResponseEntity.ok(assetService.findPopular());
    }

    @GetMapping("/{place}")
    public ResponseEntity<List<Asset>> favoriteList(@PathVariable("place") PlaceType placeType) {
        return ResponseEntity.ok(assetService.findBy(placeType));
    }

    @PostMapping("/sell")
    public ResponseEntity<Object> sell(@RequestBody BuySellRequest request) {
        assetService.sell(request.getAssetId(), request.getPrice(), request.getPrice(), request.getUserId());

        return ResponseEntity.ok().build();
    }
}
