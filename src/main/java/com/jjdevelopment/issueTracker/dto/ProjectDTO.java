package com.jjdevelopment.issueTracker.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ProjectDTO {
    @NotBlank(message = "Name is mandatory")
    @Size(min = 5, max = 255)
    private String name;
    @Size(min = 5, max = 255)
    private String url;
}
