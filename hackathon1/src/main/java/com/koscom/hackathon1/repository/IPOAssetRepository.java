package com.koscom.hackathon1.repository;


import com.koscom.hackathon1.domain.IPOAsset;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IPOAssetRepository {
    private MongoTemplate mongoTemplate;

    public IPOAssetRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public IPOAsset save(IPOAsset ipoAsset) {
        return mongoTemplate.save(ipoAsset);
    }

    public List<IPOAsset> findAll() {
        return mongoTemplate.findAll(IPOAsset.class);
    }

    public List<IPOAsset> findBy(List<Long> ipoIds) {
        Criteria criteria = Criteria.where("asset_id").in(ipoIds);

        return mongoTemplate.find(Query.query(criteria), IPOAsset.class);
    }
}
