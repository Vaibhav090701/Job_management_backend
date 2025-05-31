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

    public List<Job> filterJobs(String jobTitle, String location, String jobType, String salaryRange) {
        double min = 0;
        double max = Integer.MAX_VALUE;

        if (salaryRange != null && salaryRange.contains("-")) {
            String[] parts = salaryRange.split("-");
            try {
                min = Double.parseDouble(parts[0]);
                max = Double.parseDouble(parts[1]);
            } catch (NumberFormatException ignored) {}
        }

        final double minSalary = min;
        final double maxSalary = max;

        return jobRepository.findAll().stream()
            .filter(job -> (jobTitle == null || job.getJobTitle().toLowerCase().contains(jobTitle.toLowerCase())))
            .filter(job -> (location == null || job.getLocation().toLowerCase().equals(location.toLowerCase())))
            .filter(job -> (jobType == null || job.getJobType().equalsIgnoreCase(jobType)))
            .filter(job -> {
                try {
                    double jobMin = job.getMinSalary();
                    double jobMax = job.getMaxSalary();
                    return jobMax >= minSalary && jobMin <= maxSalary;
                } catch (Exception e) {
                    return true; // Don't filter if parsing fails
                }
            })
            .toList();
    }

}
