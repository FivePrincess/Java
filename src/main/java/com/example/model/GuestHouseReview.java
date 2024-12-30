package main.java.com.example.model;

public class GuestHouseReview extends Review {
    private GuestHouse guestHouse; // GuestHouse 객체 참조

    // Getters and Setters
    public GuestHouse getGuestHouse() {
        return guestHouse;
    }

    public void setGuestHouse(GuestHouse guestHouse) {
        this.guestHouse = guestHouse;
    }

    // Override the abstract method
    @Override
    public void displayReviewDetails() {
        System.out.println("GuestHouse Review Details:");
        System.out.println("Review ID: " + getReviewId());
        System.out.println("GuestHouse: " + (guestHouse != null ? guestHouse.getGuesthouseName() : "No GuestHouse"));
        System.out.println("Rating: " + getRating());
        System.out.println("Content: " + getContent());
        System.out.println("Date: " + getDate());
    }
}
