package com.koscom.hackathon1.repository;

import com.koscom.hackathon1.domain.Issue;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IssueRepository {
    private final MongoTemplate mongoTemplate;

    IssueRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Issue save(Issue issue) {
        return mongoTemplate.save(issue);
    }

    public List<Issue> findAll() {
        return mongoTemplate.findAll(Issue.class);
    }
}
