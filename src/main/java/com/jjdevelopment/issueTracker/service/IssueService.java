package com.jjdevelopment.issueTracker.service;

import com.jjdevelopment.issueTracker.dto.IssueDTO;
import com.jjdevelopment.issueTracker.model.Issue;
import com.jjdevelopment.issueTracker.repository.IssueRepository;
import com.jjdevelopment.issueTracker.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;


@Service
@Transactional
@RequiredArgsConstructor
public class IssueService {

    private final IssueRepository issueRepository;
    private final ProjectRepository projectRepository;
    private final DozerBeanMapper beanMapper;

    public void createIssue(IssueDTO issueDTO) {
        Issue issue = beanMapper.map(issueDTO, Issue.class);
        issue.setProject(projectRepository.findById(issueDTO.getProjectId())
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Project with id [%d] not found", issueDTO.getProjectId()))));
        issueRepository.save(issue);
    }
}
