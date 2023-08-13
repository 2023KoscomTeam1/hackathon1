package com.koscom.hackathon1.service;

import com.koscom.hackathon1.domain.Asset;
import com.koscom.hackathon1.domain.Order;
import com.koscom.hackathon1.domain.OrderType;
import com.koscom.hackathon1.domain.PlaceType;
import com.koscom.hackathon1.repository.AssetRepository;
import com.koscom.hackathon1.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssetService {
    private final AssetRepository assetRepository;
    private final OrderRepository orderRepository;

    public AssetService(AssetRepository assetRepository, OrderRepository orderRepository) {
        this.assetRepository = assetRepository;
        this.orderRepository = orderRepository;
    }

    public List<Asset> findAll() {
        return assetRepository.findAll();
    }

    public List<Asset> findPopular() {
        Comparator<Asset> compare = Comparator
                .comparing(Asset::getViewCount);

        return assetRepository.findAll().stream()
                .sorted(compare)
                .collect(Collectors.toList());
    }

    public Asset findBy(String assetId) {
        return assetRepository.findBy(assetId);
    }

    public List<Asset> findBy(PlaceType placeType) {
        return assetRepository.findBy(placeType);
    }

    public void buy(Long assetId, Long price, Long count, String userId) {
        Order newOrder = order(userId, assetId, OrderType.BUY, price, count);

        orderRepository.save(newOrder);
    }

    public void sell(Long assetId, Long price, Long count, String userId) {
        Order newOrder = order(userId, assetId, OrderType.SELL, price, count);

        orderRepository.save(newOrder);
    }

    private Order order(String userId, Long assetId, OrderType orderType, Long price, Long count) {
        Order order = new Order();

        order.setUserId(userId);
        order.setAssetId(assetId);
        order.setOrderType(orderType);
        order.setPrice(price);
        order.setCount(count);

        return order;
    }
}
