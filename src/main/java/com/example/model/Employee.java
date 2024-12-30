package main.java.com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Employee extends User {
    private String employeeName;
    private int age;
    private String profile;
    private String mbti;
    private String instagram;
    private String[] hashtag;

    // Resume와의 1:N 관계
    private List<Resume> resumes = new ArrayList<>();

    // Getters and Setters
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getMbti() {
        return mbti;
    }

    public void setMbti(String mbti) {
        this.mbti = mbti;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String[] getHashtag() {
        return hashtag;
    }

    public void setHashtag(String[] hashtag) {
        this.hashtag = hashtag;
    }

    public List<Resume> getResumes() {
        return resumes;
    }

    public void addResume(Resume resume) {
        resumes.add(resume);
        resume.setEmployee(this); // Resume 객체와 관계 설정
    }

    @Override
    public void displayUserInfo() {
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Age: " + age);
        System.out.println("Profile: " + profile);
        System.out.println("MBTI: " + mbti);
        System.out.println("Instagram: " + instagram);
        System.out.println("Hashtags: " + String.join(", ", hashtag));
        System.out.println("Resumes:");
        for (Resume resume : resumes) {
            System.out.println("- Resume ID: " + resume.getResumeId() + ", Title: " + resume.getTitle());
        }
    }
}
