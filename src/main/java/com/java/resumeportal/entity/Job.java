package com.java.resumeportal.entity;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "company")
    private String company;
    @Column(name = "designation")
    private String designation;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "job_status")
    private boolean CurrentJob;
    @Column(name = "job_summary")
    private String jobSummary;


    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", designation='" + designation + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", CurrentJob=" + CurrentJob +
                ", jobSummary='" + jobSummary + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getFormattedStartDate(){
        return startDate.format(DateTimeFormatter.ofPattern("MMM-yyyy"));
    }

    public String getFormattedEndDate(){
        return endDate.format(DateTimeFormatter.ofPattern("MMM-yyyy"));
    }

    public boolean isCurrentJob() {
        return CurrentJob;
    }

    public void setCurrentJob(boolean currentJob) {
        CurrentJob = currentJob;
    }

    public String getJobSummary() {
        return jobSummary;
    }

    public void setJobSummary(String jobSummary) {
        this.jobSummary = jobSummary;
    }
}
