package com.jobmanagement.dashboard.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jobmanagement.dashboard.entity.Job;
import com.jobmanagement.dashboard.service.JobService;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
    	System.out.println("Job Data- "+job);
        return ResponseEntity.ok(jobService.createJob(job));
    }

    @GetMapping("/filter")
    public List<Job> filterJobs(
            @RequestParam(required = false) String jobTitle,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String jobType,
            @RequestParam(required = false) String salarayRange) {
        return jobService.filterJobs(jobTitle, location, jobType, salarayRange);
    }
    
    @GetMapping("/dummy")
    public List<Job> dummyApi() {
    	return null;
    }
}
