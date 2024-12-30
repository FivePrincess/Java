package main.java.com.example.model;

import java.util.Date;

public class WorkExperience {
    int workExperienceId;
    public String workplaceName;
    public Date startDate;
    public Date endDate;
    public String workContent;

    public WorkExperience(int workExperienceId, String workplaceName, Date startDate, Date endDate, String workContent) {
        this.workExperienceId = workExperienceId;
        this.workplaceName = workplaceName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.workContent = workContent;
    }
}
