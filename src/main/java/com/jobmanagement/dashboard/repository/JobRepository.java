package com.jobmanagement.dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.jobmanagement.dashboard.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> findByJobTitleContainingIgnoreCase(String jobTitle);
    List<Job> findByLocationContainingIgnoreCase(String location);
    List<Job> findByJobType(String jobType);

}
