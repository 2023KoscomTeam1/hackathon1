package com.koscom.hackathon1.repository;

import com.koscom.hackathon1.domain.Asset;
import com.koscom.hackathon1.domain.UserInfo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@EnableMongoRepositories
public interface AssetRepository extends MongoRepository<Asset, ObjectId> {
}
