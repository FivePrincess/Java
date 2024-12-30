package main.java.com.example.model;

import java.util.Date;

public class Resume {
    private int resumeId;
    private String title;
    private Date updatedAt;
    private String address;
    private String phoneNumber;
    private String instagram;
    private String mbti;

    // Employee와의 관계
    private Employee employee;

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

    // Display Resume Details
    public void displayResumeDetails() {
        System.out.println("Resume Details:");
        System.out.println("Resume ID: " + resumeId);
        System.out.println("Title: " + title);
        System.out.println("Updated At: " + updatedAt);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Instagram: " + instagram);
        System.out.println("MBTI: " + mbti);
        System.out.println("Employee: " + (employee != null ? employee.getEmployeeName() : "No Employee"));
    }
}
