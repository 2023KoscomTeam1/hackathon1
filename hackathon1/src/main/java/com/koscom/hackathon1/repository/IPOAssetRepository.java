package com.koscom.hackathon1.repository;


import com.koscom.hackathon1.domain.IPOAsset;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface IPOAssetRepository extends MongoRepository<IPOAsset, ObjectId> {
}
