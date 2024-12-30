package main.java.com.example.model;

import java.util.ArrayList;
import java.util.List;


public class PaidCustomer {
    private int subscriptionId;
    private Employer employer; // Employer 객체 참조

    // Getter and Setter for subscriptionId
    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    // Getter and Setter for employer
    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    // Method to display customer information
    public void displayCustomerInfo() {
        System.out.println("Subscription ID: " + subscriptionId);
        if (employer != null) {
            System.out.println("Employer Name: " + employer.getEmployerName());
        }
    }
}
