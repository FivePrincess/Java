package main.java.com.example.model;

public class Payment {
    private int paymentId;
    private String method;
    private float amount;
    private String status;

    public Payment(int paymentId, String method, float amount, String status) {
        this.paymentId = paymentId;
        this.method = method;
        this.amount = amount;
        this.status = status;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayPaymentDetails() {
        System.out.println("Payment ID: " + paymentId);
        System.out.println("Method: " + method);
        System.out.println("Amount: " + amount);
        System.out.println("Status: " + status);
    }
}
