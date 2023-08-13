package com.koscom.hackathon1.repository;


import com.koscom.hackathon1.domain.IPOAsset;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IPOAssetRepository {
    private final MongoTemplate mongoTemplate;

    public IPOAssetRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public IPOAsset save(IPOAsset ipoAsset) {
        return mongoTemplate.save(ipoAsset);
    }

    public List<IPOAsset> findAll() {
        return mongoTemplate.findAll(IPOAsset.class);
    }

    public IPOAsset findBy(Long ipoId) {
        Criteria criteria = Criteria.where("ipo_id").is(ipoId);

        return mongoTemplate.findOne(Query.query(criteria), IPOAsset.class);
    }

    public List<IPOAsset> findBy(List<Long> ipoIds) {
        Criteria criteria = Criteria.where("ipo_id").in(ipoIds);

        return mongoTemplate.find(Query.query(criteria), IPOAsset.class);
    }
}
