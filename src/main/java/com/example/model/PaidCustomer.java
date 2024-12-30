package main.java.com.example.model;

import java.util.ArrayList;
import java.util.List;

public class PaidCustomer {
    private int subscriptionId;
    private int employerId;
    private List<Payment> payments; // 여러 결제 정보를 저장

    public PaidCustomer(int subscriptionId, int employerId) {
        this.subscriptionId = subscriptionId;
        this.employerId = employerId;
        this.payments = new ArrayList<>(); // 초기화
    }

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public int getEmployerId() {
        return employerId;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    // 결제 정보 추가
    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    public void displayCustomerInfo() {
        System.out.println("Subscription ID: " + subscriptionId);
        System.out.println("Employer ID: " + employerId);
        System.out.println("Payments:");
        for (Payment payment : payments) {
            payment.displayPaymentDetails();
        }
    }
}
