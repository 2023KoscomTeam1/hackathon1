package com.koscom.hackathon1.repository;

import com.koscom.hackathon1.domain.UserInfo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

@Component
public class UserRepository {
    private final MongoTemplate mongoTemplate;

    public UserRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public UserInfo save(UserInfo userInfo) {
        return mongoTemplate.save(userInfo);
    }
    public UserInfo findBy(String userId) {
        Criteria criteria = Criteria.where("user_id").is(userId);

        return mongoTemplate.findOne(Query.query(criteria), UserInfo.class);
    }
}
