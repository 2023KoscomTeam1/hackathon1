package com.koscom.hackathon1.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BalanceAddRequest {
    @JsonProperty("user_id")
    private String userId;
    private int amount;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "BalanceAddRequest{" +
                "userId='" + userId + '\'' +
                ", amount=" + amount +
                '}';
    }
}
