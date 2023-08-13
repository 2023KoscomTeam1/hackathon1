package com.koscom.hackathon1.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.koscom.hackathon1.domain.Order;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderResponse {
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "OrderResponse{" +
                "orders=" + orders +
                '}';
    }
}
