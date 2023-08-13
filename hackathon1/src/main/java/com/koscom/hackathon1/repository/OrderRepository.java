package com.koscom.hackathon1.repository;

import com.koscom.hackathon1.domain.Order;
import com.koscom.hackathon1.domain.OrderType;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderRepository {
    private final MongoTemplate mongoTemplate;

    OrderRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Order save(Order order) {
        return mongoTemplate.save(order);
    }

    public List<Order> findBy(Long assetId, OrderType orderType) {
        Criteria criteria = Criteria.where("asset_id").is(assetId)
                .and("order_type").is(orderType);

        return mongoTemplate.find(Query.query(criteria), Order.class);
    }
}
