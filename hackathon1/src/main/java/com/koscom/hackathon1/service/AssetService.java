package com.koscom.hackathon1.service;

import com.koscom.hackathon1.domain.*;
import com.koscom.hackathon1.exception.InsufficientBalanceException;
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
        Long userBalance = userRepository.findBy(userId).getBalance();
        if (price * count > userBalance) {
            throw new InsufficientBalanceException("Insufficient Balance Exception");
        }

        Long leftCount = matchOrder(newOrder);
        newOrder.setCount(leftCount);

        modifyBalance(userId, userBalance - (price * count));

        if (leftCount > 0) {
            orderRepository.save(newOrder);
        }
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

        Long leftCount = matchOrder(newOrder);
        newOrder.setCount(leftCount);

        if (leftCount > 0) {
            orderRepository.save(newOrder);
        }
    }

    private Long matchOrder(Order order) {
        if (order.getOrderType() == OrderType.BUY) {
            return matchOrder(order, OrderType.SELL);
        }

        return matchOrder(order, OrderType.BUY);
    }

    private Long matchOrder(Order order, OrderType countOrderType) {
        List<Order> countOrders = orderRepository.findBy(order.getAssetId(), countOrderType, order.getPrice());
        countOrders.forEach(countOrder -> {
            Long countOrderCount = countOrder.getCount();
            Long currentCount = order.getCount();

            if (countOrder.getUserId().equals(order.getUserId())) {
                return;
            }

            if (currentCount <= 0) {
                return;
            }

            modifyAssetEndPrice(order.getAssetId(), order.getPrice());

            if (countOrderCount <= currentCount) {
                modifyUserAsset(countOrder.getUserId(), countOrder.getAssetId(), countOrderCount, countOrder.getPrice(), countOrder.getOrderType());
                modifyUserAsset(order.getUserId(), order.getAssetId(), countOrderCount, countOrder.getPrice(), order.getOrderType());

                order.setCount(currentCount - countOrderCount);
                orderRepository.deleteBy(countOrder);
                return;
            }

            modifyUserAsset(countOrder.getUserId(), countOrder.getAssetId(), order.getCount(), countOrder.getPrice(), countOrder.getOrderType());
            modifyUserAsset(order.getUserId(), order.getAssetId(), order.getCount(), order.getPrice(), order.getOrderType());

            countOrder.setCount(countOrderCount - currentCount);
            orderRepository.save(countOrder);

            order.setCount(0L);
        });

        return order.getCount();
    }

    private void modifyAssetEndPrice(Long assetId, Long endPrice) {
        Asset asset = assetRepository.findBy(assetId);
        asset.setEndPrice(endPrice);
        assetRepository.save(asset);
    }

    private void modifyUserAsset(String userId, Long assetId, Long count, Long price, OrderType orderType) {
        UserInfo userInfo = userRepository.findBy(userId);
        List<HoldingAsset> assets = userInfo.getUserAssets();
        List<Long> assetIds = assets.stream().mapToLong(HoldingAsset::getAssetId).boxed().toList();;
        if (assetIds.contains(assetId)) {
            assets.forEach(asset -> {
                if (asset.getAssetId().equals(assetId)) {
                    if (orderType.equals(OrderType.SELL)) {
                        asset.setCount(asset.getCount() - count);
                    } else {
                        Double averagePrice = (asset.getAveragePrice()*asset.getCount() + price*count)/(asset.getCount() + count);
                        asset.setAveragePrice(averagePrice);
                        asset.setCount(asset.getCount() + count);
                    }
                }
            });
        } else {
            HoldingAsset holdingAsset = new HoldingAsset();

            holdingAsset.setCount(count);
            holdingAsset.setAssetId(assetId);
            holdingAsset.setAveragePrice(price.doubleValue());

            assets.add(holdingAsset);
        }

        if (orderType.equals(OrderType.SELL)) {
            userInfo.setBalance(userInfo.getBalance() + (count * price));
        }

        userInfo.setUserAssets(assets);

        userRepository.save(userInfo);
    }

    private void modifyBalance(String userId, Long balance) {
        UserInfo userInfo = userRepository.findBy(userId);
        userInfo.setBalance(balance);
        userRepository.save(userInfo);
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
