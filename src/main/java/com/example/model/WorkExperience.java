package main.java.com.example.model;

import java.util.Date;

public class WorkExperience {
    private int workExperienceId;
    private String workplaceName;
    private Date startDate;
    private Date endDate;
    private String workContent;

    // 생성자 수정
    public WorkExperience(int workExperienceId, String workplaceName, Date startDate, Date endDate, String workContent) {
        this.workExperienceId = workExperienceId;
        this.workplaceName = workplaceName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.workContent = workContent;
    }

    // Getter 메서드 추가
    public int getWorkExperienceId() {
        return workExperienceId;
    }

    public String getWorkplaceName() {
        return workplaceName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getWorkContent() {
        return workContent;
    }
}
