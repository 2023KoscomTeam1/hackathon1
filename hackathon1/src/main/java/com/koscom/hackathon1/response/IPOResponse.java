package com.koscom.hackathon1.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.koscom.hackathon1.domain.IPOAsset;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class IPOResponse {
    private List<IPOAsset> ipoAssets;

    public List<IPOAsset> getIpoAssets() {
        return ipoAssets;
    }

    public void setIpoAssets(List<IPOAsset> ipoAssets) {
        this.ipoAssets = ipoAssets;
    }

    @Override
    public String toString() {
        return "IPOResponse{" +
                "ipoAssets=" + ipoAssets +
                '}';
    }
}
