package com.koscom.hackathon1.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BalanceAddRequest {
    @JsonProperty("user_id")
    private String userId;
    private Long amount;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
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
