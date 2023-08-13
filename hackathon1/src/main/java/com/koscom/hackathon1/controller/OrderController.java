package com.koscom.hackathon1.controller;

import com.koscom.hackathon1.domain.Order;
import com.koscom.hackathon1.domain.OrderType;
import com.koscom.hackathon1.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{asset_id}/buy")
    public ResponseEntity<List<Order>> getBuyOrder(@PathVariable Long assetId) {
        return ResponseEntity.ok(orderService.getOrders(assetId, OrderType.BUY));
    }

    @GetMapping("/{asset_id}/sell")
    public ResponseEntity<List<Order>> getSellOrder(@PathVariable Long assetId) {
        return ResponseEntity.ok(orderService.getOrders(assetId, OrderType.SELL));
    }
}
