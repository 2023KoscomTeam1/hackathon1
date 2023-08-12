package com.koscom.hackathon1.repository;

import com.koscom.hackathon1.domain.UserInfo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface UserRepository extends MongoRepository<UserInfo, ObjectId> {
    public UserInfo findBy(String userId);
}
