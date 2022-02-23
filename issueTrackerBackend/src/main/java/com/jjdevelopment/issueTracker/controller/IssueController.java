package com.jjdevelopment.issueTracker.controller;

import com.jjdevelopment.issueTracker.dto.IssueDTO;
import com.jjdevelopment.issueTracker.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/issue")
@RequiredArgsConstructor
public class IssueController {

    private final IssueService issueService;

    @PostMapping
    public void createIssue(@RequestBody @Valid IssueDTO issueDTO) {
        issueService.createIssue(issueDTO);
    }

}
