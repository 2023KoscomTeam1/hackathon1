package com.koscom.hackathon1.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.koscom.hackathon1.domain.Asset;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public class AssetsResponse {
    private Asset asset;
    private List<Asset> assets;

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

    @Override
    public String toString() {
        return "AssetResponse{" +
                "asset=" + asset +
                "assets=" + assets +
                '}';
    }
}
