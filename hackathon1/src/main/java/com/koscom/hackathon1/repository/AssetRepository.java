package com.koscom.hackathon1.repository;

import com.koscom.hackathon1.domain.Asset;
import com.koscom.hackathon1.domain.PlaceType;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AssetRepository {
    private final MongoTemplate mongoTemplate;

    public AssetRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Asset> findBy(PlaceType placeType) {
        Criteria criteria = Criteria.where("place_type").is(placeType);

        return mongoTemplate.find(Query.query(criteria), Asset.class);
    }

    public Asset save(Asset asset) {
        return mongoTemplate.save(asset);
    }

    public List<Asset> findAll() {
        return mongoTemplate.findAll(Asset.class);
    }
}
