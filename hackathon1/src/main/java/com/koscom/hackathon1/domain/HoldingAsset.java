package com.koscom.hackathon1.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class HoldingAsset {
    @Field("asset_id")
    private Long assetId;
    private Long count;
    @Field("average_price")
    private Double averagePrice;

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }

    @Override
    public String toString() {
        return "HoldingAsset{" +
                "assetId=" + assetId +
                ", count=" + count +
                ", averagePrice=" + averagePrice +
                '}';
    }
}
