package main.java.com.example.model;

public class Employee extends User {
    private String employeeName;
    private int age;
    private String profile;
    private String mbti;
    private String instagram;
    private String[] hashtag;

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

    @Override
    public void displayUserInfo() {
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Age: " + age);
        System.out.println("Profile: " + profile);
        System.out.println("MBTI: " + mbti);
        System.out.println("Instagram: " + instagram);
        System.out.println("Hashtags: " + String.join(", ", hashtag));
    }
}
