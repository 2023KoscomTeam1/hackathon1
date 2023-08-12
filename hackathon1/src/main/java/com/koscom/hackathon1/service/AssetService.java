package com.koscom.hackathon1.service;

import com.koscom.hackathon1.domain.Asset;
import com.koscom.hackathon1.domain.PlaceType;
import com.koscom.hackathon1.repository.AssetRepository;
import org.springframework.stereotype.Component;

import java.util.Comparator;
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

    public List<Asset> findPopular() {
        Comparator<Asset> compare = Comparator
                .comparing(Asset::getViewCount);

        return assetRepository.findAll().stream()
                .sorted(compare)
                .collect(Collectors.toList());
    }

    public Asset findBy(String assetId) {
        return assetRepository.findBy(assetId);
    }

    public List<Asset> findBy(PlaceType placeType) {
        return assetRepository.findBy(placeType);
    }
}
