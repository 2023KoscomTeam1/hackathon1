package com.koscom.hackathon1.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("issues")
public class Issue {
    @Id
    private ObjectId _id;
    @Field("issue_id")
    private Long issueId;
    @Field("topic_name")
    private String topicName;
    @Field("image_url")
    private String imageUrl;

    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "_id=" + _id +
                ", issueId=" + issueId +
                ", topicName='" + topicName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
