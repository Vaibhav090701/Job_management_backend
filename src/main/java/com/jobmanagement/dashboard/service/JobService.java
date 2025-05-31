package com.jobmanagement.dashboard.service;
import org.springframework.stereotype.Service;

import com.jobmanagement.dashboard.entity.Job;
import com.jobmanagement.dashboard.repository.JobRepository;

import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public List<Job> filterJobs(String jobTitle, String location, String jobType) {
        if (jobTitle != null && !jobTitle.isEmpty()) {
            return jobRepository.findByJobTitleContainingIgnoreCase(jobTitle);
        } else if (location != null && !location.isEmpty()) {
            return jobRepository.findByLocationContainingIgnoreCase(location);
        } else if (jobType != null && !jobType.isEmpty()) {
            return jobRepository.findByJobType(jobType);
        }
        return jobRepository.findAll();
    }
}
