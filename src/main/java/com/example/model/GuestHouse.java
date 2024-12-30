package main.java.com.example.model;

import java.util.ArrayList;
import java.util.List;

public class GuestHouse {
    private Long guesthouseId;
    private String guesthouseName;
    private String location;
    private String facilities;
    private String contact;
    private String intro;
    private double averageRating;
    private String[] hashtag;
    private String image;

    // Employer와의 관계
    private Employer employer;

    // Announcement와의 1:N 관계
    private List<Announcement> announcements = new ArrayList<>();

    // GuestHouseReview와의 1:N 관계
    private List<GuestHouseReview> reviews = new ArrayList<>();

    // Getters and Setters
    public Long getGuesthouseId() {
        return guesthouseId;
    }

    public void setGuesthouseId(Long guesthouseId) {
        this.guesthouseId = guesthouseId;
    }

    public String getGuesthouseName() {
        return guesthouseName;
    }

    public void setGuesthouseName(String guesthouseName) {
        this.guesthouseName = guesthouseName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public String[] getHashtag() {
        return hashtag;
    }

    public void setHashtag(String[] hashtag) {
        this.hashtag = hashtag;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public List<Announcement> getAnnouncements() {
        return announcements;
    }

    public void addAnnouncement(Announcement announcement) {
        announcements.add(announcement);
    }

    public List<GuestHouseReview> getReviews() {
        return reviews;
    }

    public void addReview(GuestHouseReview review) {
        reviews.add(review);
        review.setGuestHouse(this); // GuestHouseReview의 GuestHouse 설정
    }

    public void displayGuestHouseDetails() {
        System.out.println("GuestHouse Details:");
        System.out.println("ID: " + guesthouseId);
        System.out.println("Name: " + guesthouseName);
        System.out.println("Location: " + location);
        System.out.println("Facilities: " + facilities);
        System.out.println("Contact: " + contact);
        System.out.println("Intro: " + intro);
        System.out.println("Average Rating: " + averageRating);
        System.out.println("Hashtags: " + (hashtag != null ? String.join(", ", hashtag) : "No hashtags"));
        System.out.println("Image: " + image);
        System.out.println("Employer: " + (employer != null ? employer.getEmployerName() : "No Employer"));
        System.out.println("Announcements:");
        for (Announcement announcement : announcements) {
            System.out.println("- " + announcement.getTitle());
        }
        System.out.println("Reviews:");
        for (GuestHouseReview review : reviews) {
            System.out.println("- Review ID: " + review.getReviewId() + ", Rating: " + review.getRating());
        }
    }
}
