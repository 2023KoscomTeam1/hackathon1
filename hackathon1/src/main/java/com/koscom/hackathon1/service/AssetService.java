package com.koscom.hackathon1.service;

import com.koscom.hackathon1.domain.Asset;
import com.koscom.hackathon1.domain.PlaceType;
import com.koscom.hackathon1.domain.UserInfo;
import com.koscom.hackathon1.repository.AssetRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssetService {
    private final AssetRepository assetRepository;

    public AssetService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public List<Asset> findAll() {
        return assetRepository.findAll();
    }

    public List<Asset> findByPlace(PlaceType placeType) {
        return assetRepository.findBy(placeType);
    }
}
