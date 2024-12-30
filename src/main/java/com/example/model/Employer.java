package main.java.com.example.model;

public class Employer extends User {
    private String employerName;
    private String employerPhoneNumber;
    private String businessLicenseNumber;

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

    @Override
    public void displayUserInfo() {
        System.out.println("Employer Name: " + employerName);
        System.out.println("Phone Number: " + employerPhoneNumber);
        System.out.println("Business License Number: " + businessLicenseNumber);
    }
}
