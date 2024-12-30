package main.java.com.example.model;// Resume.java
import main.java.com.example.model.WorkExperience;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Resume {
    private String employeeId;
    private String title;
    private String address;
    private String phoneNumber;
    private String instagram;
    private Date updatedAt;
    private ArrayList<WorkExperience> workExperience;

    public Resume(String employeeId, String title, String address, String phoneNumber, String instagram) {
        this.employeeId = employeeId;
        this.title = title;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.instagram = instagram;
        this.updatedAt = new Date();
        this.workExperience = new ArrayList<>();
    }

    // Getter 및 Setter 메서드
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public ArrayList<WorkExperience> getWorkExperience() {
        return workExperience;
    }

    public void addWorkExperience(WorkExperience experience) {
        this.workExperience.add(experience);
    }

    @Override
    public String toString() {
        return title + " - " + phoneNumber + " - " + instagram;
    }

    public String toDetailString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        StringBuilder details = new StringBuilder();
        details.append("Employee ID: ").append(employeeId).append("\n");
        details.append("Title: ").append(title).append("\n");
        details.append("Updated At: ").append(sdf.format(updatedAt)).append("\n");
        details.append("Address: ").append(address).append("\n");
        details.append("Phone Number: ").append(phoneNumber).append("\n");
        details.append("Instagram: ").append(instagram).append("\n\n");

        details.append("Work Experience:\n");
        for (WorkExperience exp : workExperience) {
            details.append("- ").append(exp.getWorkplaceName()).append(" (")
                    .append(sdf.format(exp.getStartDate())).append(" ~ ")
                    .append(sdf.format(exp.getEndDate())).append(")\n");
            details.append("  Content: ").append(exp.getWorkContent()).append("\n\n");
        }
        return details.toString();
    }
}
