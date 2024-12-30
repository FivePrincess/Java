package main.java.com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Employee extends User {
    private String employeeName;
    private String position;
    private String contact;

    // EmployeeReview와의 1:N 관계
    private List<EmployeeReview> reviews = new ArrayList<>();

    // Resume와의 1:N 관계
    private List<Resume> resumes = new ArrayList<>();

    // Getters and Setters
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<EmployeeReview> getReviews() {
        return reviews;
    }

    public void addReview(EmployeeReview review) {
        reviews.add(review);
        review.setEmployee(this); // Employee 객체 설정
    }

    public List<Resume> getResumes() {
        return resumes;
    }

    public void addResume(Resume resume) {
        resumes.add(resume);
        resume.setEmployee(this); // Resume 객체와의 관계 설정
    }

    @Override
    public void displayUserInfo() {
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Position: " + position);
        System.out.println("Contact: " + contact);
        System.out.println("Resumes:");
        for (Resume resume : resumes) {
            System.out.println("- Resume ID: " + resume.getResumeId() + ", Title: " + resume.getTitle());
        }
        System.out.println("Reviews:");
        for (EmployeeReview review : reviews) {
            System.out.println("- Review ID: " + review.getReviewId() + ", Rating: " + review.getRating());
        }
    }
}
