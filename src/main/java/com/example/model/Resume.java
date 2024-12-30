package main.java.com.example.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Resume {
    private String resumeId;
    private String title;
    private String address;
    private String phoneNumber;
    private String instagram;
    private ArrayList<WorkExperience> workExperience;
    private Date updatedAt;
    private Employee employee;  // Employee와의 관계 추가

    public Resume(String resumeId, String title, String address, String phoneNumber, String instagram) {
        this.resumeId = resumeId;
        this.title = title;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.instagram = instagram;
        this.workExperience = new ArrayList<>();
        this.updatedAt = new Date();
    }

    // Employee 설정 메서드 추가
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    // Resume ID 반환 메서드 추가
    public String getResumeId() {
        return resumeId;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getInstagram() {
        return instagram;
    }

    public ArrayList<WorkExperience> getWorkExperience() {
        return workExperience;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setTitle(String title) {
        this.title = title;
        this.updatedAt = new Date();
    }

    public void setAddress(String address) {
        this.address = address;
        this.updatedAt = new Date();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.updatedAt = new Date();
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
        this.updatedAt = new Date();
    }

    public void addWorkExperience(WorkExperience experience) {
        workExperience.add(experience);
        this.updatedAt = new Date();
    }

    public String toDetailString() {
        StringBuilder details = new StringBuilder();
        details.append("이력서 ID: ").append(resumeId).append("\n");
        details.append("제목: ").append(title).append("\n");
        details.append("주소: ").append(address).append("\n");
        details.append("전화번호: ").append(phoneNumber).append("\n");
        details.append("인스타그램: ").append(instagram).append("\n");
        details.append("수정 날짜: ").append(new SimpleDateFormat("yyyy-MM-dd").format(updatedAt)).append("\n\n");

        if (!workExperience.isEmpty()) {
            details.append("경력 사항:\n");
            for (WorkExperience exp : workExperience) {
                details.append("- 직장명: ").append(exp.getWorkplaceName()).append("\n");
                details.append("  기간: ")
                        .append(new SimpleDateFormat("yyyy-MM-dd").format(exp.getStartDate()))
                        .append(" ~ ")
                        .append(new SimpleDateFormat("yyyy-MM-dd").format(exp.getEndDate()))
                        .append("\n업무 내용: ").append(exp.getWorkContent()).append("\n\n");
            }
        } else {
            details.append("경력 없음\n");
        }

        return details.toString();
    }
}
