package main.java.com.example.ui;

import main.java.com.example.model.Review;
import main.java.com.example.ui.ReviewManager;

import java.util.List;  // List 컬렉션 인터페이스
import java.util.ArrayList;  // ArrayList 구현 클래스

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReviewController {
    private JTextField guesthouseField;
    private JTextField visitDatesField;
    private JTextArea reviewTextArea;
    private List<JButton> starButtons;
    private int rating = 0;
    private JPanel reviewListPanel;
    private ReviewManager reviewManager;

    public ReviewController() {
        reviewManager = new ReviewManager();
        initialize();
    }

    private void initialize() {
        JFrame frame = new JFrame("리뷰 작성 프로그램");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 창만 닫히도록 설정
        frame.setSize(500, 600);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 게스트하우스 이름 입력
        mainPanel.add(new JLabel("게스트하우스 이름"));
        guesthouseField = new JTextField();
        mainPanel.add(guesthouseField);

        // 방문 기간 입력
        mainPanel.add(new JLabel("방문 기간 (예: 2024.07.12 ~ 2024.08.12)"));
        visitDatesField = new JTextField();
        mainPanel.add(visitDatesField);

        // 평점 입력
        mainPanel.add(new JLabel("평점 (1 ~ 5)"));
        JPanel starPanel = new JPanel();
        starPanel.setLayout(new FlowLayout());
        starButtons = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            JButton starButton = new JButton("★");
            starButton.setFont(new Font("Arial", Font.PLAIN, 20));
            final int starRating = i;
            starButton.addActionListener(e -> setRating(starRating));
            starButtons.add(starButton);
            starPanel.add(starButton);
        }
        mainPanel.add(starPanel);

        // 리뷰 내용 입력
        mainPanel.add(new JLabel("리뷰 내용"));
        reviewTextArea = new JTextArea(5, 30);
        reviewTextArea.setLineWrap(true);
        reviewTextArea.setWrapStyleWord(true);
        mainPanel.add(new JScrollPane(reviewTextArea));

        // 등록 버튼
        JButton submitButton = new JButton("등록");
        submitButton.addActionListener(new SubmitButtonListener());
        mainPanel.add(submitButton);

        // 리뷰 목록
        reviewListPanel = new JPanel();
        reviewListPanel.setLayout(new BoxLayout(reviewListPanel, BoxLayout.Y_AXIS));
        mainPanel.add(new JLabel("작성된 리뷰 목록"));
        JScrollPane scrollPane = new JScrollPane(reviewListPanel);
        scrollPane.setPreferredSize(new Dimension(450, 200));
        mainPanel.add(scrollPane);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private void setRating(int rating) {
        this.rating = rating;
        for (int i = 0; i < starButtons.size(); i++) {
            if (i < rating) {
                starButtons.get(i).setForeground(Color.YELLOW);
            } else {
                starButtons.get(i).setForeground(Color.GRAY);
            }
        }
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String guesthouseName = guesthouseField.getText();
            String visitDates = visitDatesField.getText();
            String reviewContent = reviewTextArea.getText();

            if (guesthouseName.isEmpty() || visitDates.isEmpty() || reviewContent.isEmpty() || rating == 0) {
                JOptionPane.showMessageDialog(null, "모든 필드를 입력하고 평점을 선택하세요.", "경고", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Review review = new Review(guesthouseName, visitDates, rating, reviewContent);
            reviewManager.addReview(review);
            reviewManager.displayReviews(reviewListPanel);

            guesthouseField.setText("");
            visitDatesField.setText("");
            reviewTextArea.setText("");
            setRating(0);

            JOptionPane.showMessageDialog(null, "리뷰가 성공적으로 등록되었습니다!", "성공", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
