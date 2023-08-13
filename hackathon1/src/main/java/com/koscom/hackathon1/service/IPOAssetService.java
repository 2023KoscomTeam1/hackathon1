package com.koscom.hackathon1.service;

import com.koscom.hackathon1.domain.IPOAsset;
import com.koscom.hackathon1.repository.IPOAssetRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IPOAssetService {
    private final IPOAssetRepository ipoAssetRepository;

    public IPOAssetService(IPOAssetRepository ipoAssetRepository) {
        this.ipoAssetRepository = ipoAssetRepository;
    }

    public IPOAsset save(IPOAsset ipoAsset) {
        return ipoAssetRepository.save(ipoAsset);
    }

    public List<IPOAsset> findAll() {
        return ipoAssetRepository.findAll();
    }
}
