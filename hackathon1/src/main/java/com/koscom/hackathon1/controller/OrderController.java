package com.koscom.hackathon1.controller;

import com.koscom.hackathon1.domain.OrderType;
import com.koscom.hackathon1.response.OrderResponse;
import com.koscom.hackathon1.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{assetId}/buy")
    public OrderResponse getBuyOrder(@PathVariable Long assetId) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderBook(orderService.getOrderBookBy(assetId, OrderType.BUY));

        return orderResponse;
    }

    @GetMapping("/{assetId}/sell")
    public OrderResponse getSellOrder(@PathVariable Long assetId) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderBook(orderService.getOrderBookBy(assetId, OrderType.SELL));

        return orderResponse;
    }
}
