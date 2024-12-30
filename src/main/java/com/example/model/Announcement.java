package main.java.com.example.model;

import java.util.Date;

public class Announcement {
    private Long announcementId;
    private String title;
    private String content;
    private Date startDate;
    private Date endDate;
    private int employeeNumber;
    private String contact;
    private String[] hashtag;

    // GuestHouse와의 관계
    private GuestHouse guestHouse;

    // Getters and Setters
    public Long getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(Long announcementId) {
        this.announcementId = announcementId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String[] getHashtag() {
        return hashtag;
    }

    public void setHashtag(String[] hashtag) {
        this.hashtag = hashtag;
    }

    public GuestHouse getGuestHouse() {
        return guestHouse;
    }

    public void setGuestHouse(GuestHouse guestHouse) {
        this.guestHouse = guestHouse;
    }

    public void displayAnnouncementDetails() {
        System.out.println("Announcement Details:");
        System.out.println("ID: " + announcementId);
        System.out.println("Title: " + title);
        System.out.println("Content: " + content);
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);
        System.out.println("Employee Number: " + employeeNumber);
        System.out.println("Contact: " + contact);
        System.out.println("Hashtags: " + (hashtag != null ? String.join(", ", hashtag) : "No hashtags"));
        System.out.println("GuestHouse: " + (guestHouse != null ? guestHouse.getGuesthouseName() : "No GuestHouse"));
    }
}
