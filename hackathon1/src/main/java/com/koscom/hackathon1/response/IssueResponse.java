package com.koscom.hackathon1.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.koscom.hackathon1.domain.Issue;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class IssueResponse {
    private List<Issue> issues;

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    @Override
    public String toString() {
        return "IssueResponse{" +
                "issues=" + issues +
                '}';
    }
}
