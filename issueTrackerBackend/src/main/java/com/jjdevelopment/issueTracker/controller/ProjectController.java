package com.jjdevelopment.issueTracker.controller;

import com.jjdevelopment.issueTracker.dto.IssueDTO;
import com.jjdevelopment.issueTracker.dto.ProjectDTO;
import com.jjdevelopment.issueTracker.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Validated
@RestController
@RequestMapping("/api/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public void createProject(@RequestBody @Valid ProjectDTO projectDTO) {
        projectService.createProject(projectDTO);
    }

    @GetMapping
    public List<ProjectDTO> listAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{projectId}")
    public ProjectDTO getProject(@PathVariable @Min(1) Integer projectId) {
        return projectService.getProject(projectId);
    }

    @GetMapping("/{projectId}/countIssues")
    public int countIssues(@PathVariable @Min(1) Integer projectId) {
        return projectService.countIssuesOfProject(projectId);
    }

    @GetMapping("/{projectId}/issue")
    public Page<IssueDTO> listIssues(@PathVariable Integer projectId, @RequestParam("page") int page,
                                     @RequestParam("size") int size) {
        return projectService.getIssuesByProjectId(projectId, page, size);
    }
}
