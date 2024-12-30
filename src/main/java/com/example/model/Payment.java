package main.java.com.example.model;
import java.util.Date;

public class Payment {
    private int paymentId;
    private String method;
    private float amount;
    private String status;
    private Date paymentDate;
    private Employer employer; // Employer 객체 참조

    // Getter and Setter for paymentId
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    // Getter and Setter for method
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    // Getter and Setter for amount
    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    // Getter and Setter for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getter and Setter for paymentDate
    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    // Getter and Setter for employer
    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    // Method to display payment details
    public void displayPaymentDetails() {
        System.out.println("Payment ID: " + paymentId);
        System.out.println("Method: " + method);
        System.out.println("Amount: " + amount);
        System.out.println("Status: " + status);
        System.out.println("Payment Date: " + paymentDate);
        if (employer != null) {
            System.out.println("Employer Name: " + employer.getEmployerName());
        }
    }
}