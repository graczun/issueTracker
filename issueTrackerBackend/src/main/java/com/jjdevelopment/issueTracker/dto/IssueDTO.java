package com.jjdevelopment.issueTracker.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class IssueDTO {

    @NotBlank(message = "Name is mandatory")
    @Size(min = 5, max = 255)
    private String name;
    @Size(max = 255)
    private String url;
    @Size(max = 4096)
    private String description;
    @Min(1)
    private int projectId;
}
