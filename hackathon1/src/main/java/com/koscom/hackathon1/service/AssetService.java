package com.koscom.hackathon1.service;

import com.koscom.hackathon1.domain.*;
import com.koscom.hackathon1.exception.InvalidOrderException;
import com.koscom.hackathon1.repository.AssetRepository;
import com.koscom.hackathon1.repository.OrderRepository;
import com.koscom.hackathon1.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssetService {
    private final AssetRepository assetRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public AssetService(AssetRepository assetRepository, OrderRepository orderRepository, UserRepository userRepository) {
        this.assetRepository = assetRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public List<Asset> findAll() {
        return assetRepository.findAll();
    }

    public List<Asset> findPopular() {
        Comparator<Asset> compare = Comparator
                .comparing(asset -> -asset.getViewCount());

        return assetRepository.findAll().stream()
                .sorted(compare)
                .collect(Collectors.toList());
    }

    public Asset findBy(Long assetId) {
        return assetRepository.findBy(assetId);
    }

    public List<Asset> findBy(PlaceType placeType) {
        return assetRepository.findBy(placeType);
    }

    public boolean view(Long assetId) {
        Asset asset = assetRepository.findBy(assetId);
        if (asset == null) {
            return false;
        }

        asset.setViewCount(asset.getViewCount() + 1);

        assetRepository.save(asset);
        return true;
    }

    public void buy(Long assetId, Long price, Long count, String userId) {
        Order newOrder = order(userId, assetId, OrderType.BUY, price, count);

            orderRepository.save(newOrder);
    }

    public void sell(Long assetId, Long price, Long count, String userId) {
        Order newOrder = order(userId, assetId, OrderType.SELL, price, count);

        List<Long> assetIds = userRepository.findBy(userId).getUserAssets()
                .stream()
                .map(HoldingAsset::getAssetId)
                .toList();

        if (!assetIds.contains(assetId)) {
            throw new InvalidOrderException("Not allowed order");
        }

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
