package com.jobmanagement.dashboard.util;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jobmanagement.dashboard.entity.Job;
import com.jobmanagement.dashboard.repository.JobRepository;

@Component
public class DataInitializer implements CommandLineRunner {
	
    private final JobRepository jobRepository;

    public DataInitializer(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

	@Override
	public void run(String... args) throws Exception {
        jobRepository.save(new Job(null, "Full Stack Developer", "Amazon", "Remote", "Full-time", 300000,  1200000, 
                "A user-friendly interface lets you browse stunning photos and videos", "1-3 Yr Exp", "Onsite", LocalDate.now().minusDays(24)));
            jobRepository.save(new Job(null, "Node Js Developer", "Tesla", "Remote", "Full-time", 300000,  1200000,
                "A user-friendly interface lets you browse stunning photos and videos", "3-7 Yr Exp", "Onsite", LocalDate.now().minusDays(24)));
            jobRepository.save(new Job(null, "UX/UI Designer", "Spotify", "Remote", "Full-time", 300000,  1200000, 
                "A user-friendly interface lets you browse stunning photos and videos", "3-7 Yr Exp", "Onsite", LocalDate.now().minusDays(24)));
            jobRepository.save(new Job(null, "Full Stack Developer", "Amazon", "Remote", "Full-time", 300000,  1200000,
                "A user-friendly interface lets you browse stunning photos and videos", "1-3 Yr Exp", "Onsite", LocalDate.now().minusDays(24)));
            jobRepository.save(new Job(null, "Node Js Developer", "Tesla", "Remote", "Full-time", 300000,  1200000, 
                "A user-friendly interface lets you browse stunning photos and videos", "3-7 Yr Exp", "Onsite", LocalDate.now().minusDays(24)));
            jobRepository.save(new Job(null, "UX/UI Designer", "Spotify", "Remote", "Full-time", 300000,  1200000,
                "A user-friendly interface lets you browse stunning photos and videos", "3-7 Yr Exp", "Onsite", LocalDate.now().minusDays(24)));
            jobRepository.save(new Job(null, "Full Stack Developer", "Amazon", "Remote", "Full-time",300000,  1200000, 
                "A user-friendly interface lets you browse stunning photos and videos", "1-3 Yr Exp", "Onsite", LocalDate.now().minusDays(24)));
            jobRepository.save(new Job(null, "Node Js Developer", "Tesla", "Remote", "Full-time", 300000,  1200000, 
                "A user-friendly interface lets you browse stunning photos and videos", "3-7 Yr Exp", "Onsite", LocalDate.now().minusDays(24)));		
	}

}
