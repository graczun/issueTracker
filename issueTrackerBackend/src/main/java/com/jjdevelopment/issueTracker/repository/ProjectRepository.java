package com.jjdevelopment.issueTracker.repository;

import com.jjdevelopment.issueTracker.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer> {

}
