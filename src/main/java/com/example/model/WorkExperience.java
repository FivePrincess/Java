package main.java.com.example.model;

import java.util.Date;

public class WorkExperience {
    private int workExperienceId;
    private String workplaceName;
    private Date startDate;
    private Date endDate;
    private String workContent;
    private Resume resume;  // Resume 필드 추가

    // 기존 생성자
    public WorkExperience(int workExperienceId, String workplaceName, Date startDate, Date endDate, String workContent) {
        this.workExperienceId = workExperienceId;
        this.workplaceName = workplaceName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.workContent = workContent;
    }

    // 새로운 생성자 (Resume 포함)
    public WorkExperience(int workExperienceId, String workplaceName, Date startDate, Date endDate, String workContent, Resume resume) {
        this.workExperienceId = workExperienceId;
        this.workplaceName = workplaceName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.workContent = workContent;
        this.resume = resume;
    }

    // Getter 및 Setter 메서드
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

    @Override
    public String toString() {
        return workplaceName + " (" + startDate + " ~ " + endDate + ") - " + workContent;
    }
}
