package com.koscom.hackathon1.service;

import com.koscom.hackathon1.domain.Order;
import com.koscom.hackathon1.domain.OrderType;
import com.koscom.hackathon1.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Map<Long, Long> getOrderBookBy(Long assetId, OrderType orderType) {
        List<Order> orders = getOrders(assetId, orderType);
        Map<Long, Long> orderBook = new HashMap<>();

        orders.forEach(order -> {
            Long price = order.getPrice();

            if (orderBook.containsKey(price)) {
                orderBook.replace(price, order.getCount() + orderBook.get(price));
            } else {
                orderBook.put(price, order.getCount());
            }
        });

        return orderBook;
    }

    private List<Order> getOrders(Long assetId, OrderType orderType) {
        return orderRepository.findBy(assetId, orderType);
    }
}
