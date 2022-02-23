package com.jjdevelopment.issueTracker.repository;

import com.jjdevelopment.issueTracker.model.Issue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends PagingAndSortingRepository<Issue, Integer> {
    Page<Issue> findAllByProjectId(Integer projectId, Pageable pageable);
}
