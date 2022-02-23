package com.jjdevelopment.issueTracker.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class ProjectDTO {
    @NotBlank(message = "Name is mandatory")
    @Size(min = 5, max = 255)
    private String name;
    @Size(min = 5, max = 255)
    private String url;
}
