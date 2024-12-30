package main.java.com.example.model;

import java.util.Date;

public class WorkExperience {
    private int workExperienceId;   // WorkExperience ID
    private String workplaceName;  // 직장 이름
    private Date startDate;         // 시작 날짜
    private Date endDate;           // 종료 날짜
    private String workContent;     // 업무 내용

    // Resume와의 관계
    private Resume resume;

    // Getters and Setters
    public int getWorkExperienceId() {
        return workExperienceId;
    }

    public void setWorkExperienceId(int workExperienceId) {
        this.workExperienceId = workExperienceId;
    }

    public String getWorkplaceName() {
        return workplaceName;
    }

    public void setWorkplaceName(String workplaceName) {
        this.workplaceName = workplaceName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent = workContent;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    // Display WorkExperience details
    public void displayWorkExperience() {
        System.out.println("WorkExperience Details:");
        System.out.println("WorkExperience ID: " + workExperienceId);
        System.out.println("Workplace Name: " + workplaceName);
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);
        System.out.println("Work Content: " + workContent);
        System.out.println("Resume Title: " + (resume != null ? resume.getTitle() : "No Resume"));
    }
}
