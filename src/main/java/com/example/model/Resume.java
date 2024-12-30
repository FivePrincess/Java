package main.java.com.example.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Resume {
    private int resumeId;             // 이력서 ID
    private String title;             // 이력서 제목
    private Date updatedAt;           // 업데이트 날짜
    private String address;           // 주소
    private String phoneNumber;       // 전화번호
    private String instagram;         // 인스타그램 계정
    private String mbti;              // MBTI
    private Employee employee;        // Employee 객체와의 관계

    // WorkExperience와의 1:N 관계
    private List<WorkExperience> workExperiences = new ArrayList<>();

    // Constructor
    public Resume() {
        this.updatedAt = new Date();  // 생성 시 업데이트 날짜 초기화
    }

    // Getters and Setters
    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
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

    public String getMbti() {
        return mbti;
    }

    public void setMbti(String mbti) {
        this.mbti = mbti;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<WorkExperience> getWorkExperiences() {
        return workExperiences;
    }

    public void addWorkExperience(WorkExperience workExperience) {
        workExperiences.add(workExperience);
        workExperience.setResume(this); // WorkExperience와의 관계 설정
    }

    // Display Resume Details
    public void displayResumeDetails() {
        System.out.println("Resume ID: " + resumeId);
        System.out.println("Title: " + title);
        System.out.println("Updated At: " + updatedAt);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Instagram: " + instagram);
        System.out.println("MBTI: " + mbti);
        System.out.println("Employee: " + (employee != null ? employee.getEmployeeName() : "No Employee"));
        System.out.println("Work Experiences:");
        for (WorkExperience workExperience : workExperiences) {
            System.out.println("- Workplace: " + workExperience.getWorkplaceName());
        }
    }
}
