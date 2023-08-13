package com.koscom.hackathon1.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IssueRequest {

    @JsonProperty("issue_id")
    private Long issueId;
    @JsonProperty("topic_name")
    private String topicName;
    @JsonProperty("image_url")
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
        return "IssueRequest{" +
                "issueId='" + issueId + '\'' +
                ", topicName='" + topicName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
