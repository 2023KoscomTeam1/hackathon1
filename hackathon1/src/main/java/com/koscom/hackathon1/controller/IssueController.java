package com.koscom.hackathon1.controller;

import com.koscom.hackathon1.domain.Issue;
import com.koscom.hackathon1.request.IssueRequest;
import com.koscom.hackathon1.response.IssueResponse;
import com.koscom.hackathon1.service.IssueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hot_issue")
public class IssueController {

    private final IssueService issueService;

    IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody IssueRequest request) {
        issueService.save(request.getIssueId(), request.getTopicName(), request.getImageUrl());

        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public IssueResponse list() {
        IssueResponse issueResponse = new IssueResponse();
        issueResponse.setIssues(issueService.findAll());

        return issueResponse;
    }

}
