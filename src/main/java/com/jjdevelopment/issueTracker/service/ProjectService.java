package com.jjdevelopment.issueTracker.service;

import com.jjdevelopment.issueTracker.aspect.logging.Loggable;
import com.jjdevelopment.issueTracker.dto.IssueDTO;
import com.jjdevelopment.issueTracker.dto.ProjectDTO;
import com.jjdevelopment.issueTracker.model.Project;
import com.jjdevelopment.issueTracker.repository.IssueRepository;
import com.jjdevelopment.issueTracker.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Loggable
@Transactional
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final IssueRepository issueRepository;
    private final DozerBeanMapper beanMapper;

    public int countIssuesOfProject(Integer projectId) {
        Optional<Project> projectOptional = projectRepository.findById(projectId);
        return projectOptional.map(project -> project.getIssueList().size()).orElseThrow(() -> new EntityNotFoundException(
                String.format("Project with id [%d] not found", projectId)));
    }

    public void createProject(ProjectDTO projectDTO) {
        Project project = new Project();
        project.setName(projectDTO.getName());
        project.setUrl(projectDTO.getUrl());
        projectRepository.save(project);
    }

    @Transactional(readOnly = true)
    public List<ProjectDTO> getAllProjects() {
        return StreamSupport.stream(projectRepository.findAll().spliterator(), false)
                .map(project -> beanMapper.map(project, ProjectDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Page<IssueDTO> getIssuesByProjectId(Integer projectId, int page, int size) {
        return issueRepository.findAllByProjectId(projectId, PageRequest.of(page, size)).map(issue -> beanMapper.map(issue, IssueDTO.class));
    }
}
