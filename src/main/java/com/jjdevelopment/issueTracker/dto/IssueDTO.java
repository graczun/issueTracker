package com.jjdevelopment.issueTracker.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IssueDTO {
    private String name;
    private String url;
    private String description;
    private int projectId;
}
