package com.koscom.hackathon1.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.koscom.hackathon1.domain.IPOAsset;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class IPOResponse {
    @JsonProperty("ipo_asset")
    private IPOAsset ipoAsset;
    @JsonProperty("ipo_assets")
    private List<IPOAsset> ipoAssets;

    public IPOAsset getIpoAsset() {
        return ipoAsset;
    }

    public void setIpoAsset(IPOAsset ipoAsset) {
        this.ipoAsset = ipoAsset;
    }

    public List<IPOAsset> getIpoAssets() {
        return ipoAssets;
    }

    public void setIpoAssets(List<IPOAsset> ipoAssets) {
        this.ipoAssets = ipoAssets;
    }

    @Override
    public String toString() {
        return "IPOResponse{" +
                "ipoAsset=" + ipoAsset +
                ", ipoAssets=" + ipoAssets +
                '}';
    }
}
