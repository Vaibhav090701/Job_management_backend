package com.jobmanagement.dashboard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jobTitle;
    private String companyName;
    private String location;
    private String jobType;
    private double minSalary;
    private double maxSalary;
    @Column(columnDefinition = "TEXT")
    private String jobDescription;
    @Column(columnDefinition = "TEXT")
    private String requirements;
    @Column(columnDefinition = "TEXT")
    private String responsibilities;
    private LocalDate applicationDeadline;
}
