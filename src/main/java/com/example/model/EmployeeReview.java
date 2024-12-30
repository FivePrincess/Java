package main.java.com.example.model;

public class EmployeeReview extends Review {
    private Employee employee; // Employee 객체 참조
    private Employer employer; // Employer 객체 참조

    // Getters and Setters
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    // Override the abstract method
    @Override
    public void displayReviewDetails() {
        System.out.println("Employee Review Details:");
        System.out.println("Review ID: " + getReviewId());
        System.out.println("Employee: " + (employee != null ? employee.getEmployeeName() : "No Employee"));
        System.out.println("Employer: " + (employer != null ? employer.getEmployerName() : "No Employer"));
        System.out.println("Rating: " + getRating());
        System.out.println("Content: " + getContent());
        System.out.println("Date: " + getDate());
    }
}
