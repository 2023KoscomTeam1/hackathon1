package com.koscom.hackathon1.service;

import com.koscom.hackathon1.domain.Issue;
import com.koscom.hackathon1.repository.IssueRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IssueService {
    private final IssueRepository issueRepository;

    IssueService(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    public void save(Long issueId, String topicName, String imageUrl) {
        issueRepository.save(issue(issueId, topicName, imageUrl));
    }

    public List<Issue> findAll() {
        return issueRepository.findAll();
    }

    private Issue issue(Long issueId, String topicName, String imageUrl) {
        Issue issue = new Issue();

        issue.setIssueId(issueId);
        issue.setTopicName(topicName);
        issue.setImageUrl(imageUrl);

        return issue;
    }
}
