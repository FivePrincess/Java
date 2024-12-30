package main.java.com.example.model;


import java.util.Date;

public class ApplicationForm {
    private int applicationId;         // 지원서 ID
    private boolean status;            // 지원 상태 (true: 승인, false: 대기)
    private Date startDate;            // 시작 날짜
    private String workingPeriod;      // 근무 기간

    // Announcement와의 관계 (1:N 관계)
    private Announcement announcement;

    // Resume와의 관계 (1:1 관계)
    private Resume resume;

    // Getters and Setters
    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getWorkingPeriod() {
        return workingPeriod;
    }

    public void setWorkingPeriod(String workingPeriod) {
        this.workingPeriod = workingPeriod;
    }

    public Announcement getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(Announcement announcement) {
        this.announcement = announcement;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    // Display ApplicationForm Details
    public void displayApplicationDetails() {
        System.out.println("Application Form Details:");
        System.out.println("Application ID: " + applicationId);
        System.out.println("Status: " + (status ? "Approved" : "Pending"));
        System.out.println("Start Date: " + startDate);
        System.out.println("Working Period: " + workingPeriod);
        System.out.println("Announcement: " + (announcement != null ? announcement.getTitle() : "No Announcement"));
        System.out.println("Resume: " + (resume != null ? resume.getTitle() : "No Resume"));
    }
}
