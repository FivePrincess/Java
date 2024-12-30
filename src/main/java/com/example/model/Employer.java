package main.java.com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Employer extends User {
    private String employerName;
    private String employerPhoneNumber;
    private String businessLicenseNumber;

    // 일대다 관계: 여러 GuestHouse를 참조
    private List<GuestHouse> guestHouses = new ArrayList<>();

    // Getters and Setters
    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getEmployerPhoneNumber() {
        return employerPhoneNumber;
    }

    public void setEmployerPhoneNumber(String employerPhoneNumber) {
        this.employerPhoneNumber = employerPhoneNumber;
    }

    public String getBusinessLicenseNumber() {
        return businessLicenseNumber;
    }

    public void setBusinessLicenseNumber(String businessLicenseNumber) {
        this.businessLicenseNumber = businessLicenseNumber;
    }

    public List<GuestHouse> getGuestHouses() {
        return guestHouses;
    }

    public void addGuestHouse(GuestHouse guestHouse) {
        guestHouses.add(guestHouse);
        guestHouse.setEmployer(this); // Employer 객체 설정
    }

    @Override
    public void displayUserInfo() {
        System.out.println("Employer Name: " + employerName);
        System.out.println("Phone Number: " + employerPhoneNumber);
        System.out.println("Business License Number: " + businessLicenseNumber);
        System.out.println("GuestHouses: ");
        for (GuestHouse guestHouse : guestHouses) {
            System.out.println("- " + guestHouse.getGuesthouseName());
        }
    }
}
