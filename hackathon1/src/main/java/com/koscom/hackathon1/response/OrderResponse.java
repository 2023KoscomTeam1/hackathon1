package com.koscom.hackathon1.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderResponse {
    private Map<Long, Long> orderBook;

    public Map<Long, Long> getOrderBook() {
        return orderBook;
    }

    public void setOrderBook(Map<Long, Long> orderBook) {
        this.orderBook = orderBook;
    }

    @Override
    public String toString() {
        return "OrderResponse{" +
                "orderBook=" + orderBook +
                '}';
    }
}