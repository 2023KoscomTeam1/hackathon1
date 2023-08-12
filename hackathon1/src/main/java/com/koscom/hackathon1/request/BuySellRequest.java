package com.koscom.hackathon1.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BuySellRequest {
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("asset_id")
    private Long assetId;
    private Long count;
    private Long price;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BuySellRequest{" +
                "userId='" + userId + '\'' +
                ", assetId=" + assetId +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}
