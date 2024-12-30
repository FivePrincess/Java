package main.java.com.example.ui;

import main.java.com.example.model.Review;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewManager {
    private List<Review> reviews;

    public ReviewManager() {
        reviews = new ArrayList<>();
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public void displayReviews(JPanel reviewListPanel) {
        reviewListPanel.removeAll(); // 기존 리뷰 제거
        for (Review review : reviews) {
            JLabel reviewLabel = new JLabel(review.toString());
            reviewLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            reviewListPanel.add(reviewLabel);
        }
        reviewListPanel.revalidate();
        reviewListPanel.repaint();
    }
}
