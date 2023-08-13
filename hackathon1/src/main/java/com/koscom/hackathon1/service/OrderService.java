package com.koscom.hackathon1.service;

import com.koscom.hackathon1.domain.Order;
import com.koscom.hackathon1.domain.OrderType;
import com.koscom.hackathon1.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrders(Long assetId, OrderType orderType) {
        return orderRepository.findBy(assetId, orderType);
    }
}
