package main.java.com.example.ui;

import main.java.com.example.model.EmployeeReview;
import main.java.com.example.model.Employee;
import main.java.com.example.model.Employer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeReviewController {
    private int rating = 0;
    private JPanel reviewListPanel;
    private List<EmployeeReview> reviews; // EmployeeReview 데이터를 저장하는 리스트

    public EmployeeReviewController() {
        reviews = new ArrayList<>();

        JFrame frame = new JFrame("구직자 리뷰 작성 프로그램");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 700);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 리뷰 작성 UI
        JTextField employeeNameField = addTextField(panel, "구직자 이름:");
        JTextField employerNameField = addTextField(panel, "고용주 이름:");
        JTextField visitDatesField = addTextField(panel, "근무 기간 (예: 2024.07.12 ~ 2024.08.12):");
        JTextArea reviewTextArea = addTextArea(panel, "리뷰 내용:");

        // 별점 UI
        panel.add(new JLabel("평점 (1 ~ 5):"));
        panel.add(createStarRatingPanel());

        // 등록 버튼
        JButton submitButton = new JButton("등록");
        submitButton.addActionListener(e -> {
            if (rating == 0) {
                JOptionPane.showMessageDialog(frame, "별점을 선택해주세요!", "오류", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String employeeName = employeeNameField.getText();
            String employerName = employerNameField.getText();
            String visitDates = visitDatesField.getText();
            String reviewContent = reviewTextArea.getText();

            if (employeeName.isEmpty() || employerName.isEmpty() || visitDates.isEmpty() || reviewContent.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "모든 필드를 입력해주세요!", "오류", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Employee와 Employer 객체 생성 및 설정
            Employee employee = new Employee();
            employee.setEmployeeName(employeeName);

            Employer employer = new Employer();
            employer.setEmployerName(employerName);

            // 리뷰 데이터 저장 및 목록에 추가
            EmployeeReview review = new EmployeeReview();
            review.setEmployee(employee);
            review.setEmployer(employer);
            review.setContent(reviewContent);
            review.setRating(rating);

            reviews.add(review);
            addReviewToList(review);

            // 입력 필드 초기화
            employeeNameField.setText("");
            employerNameField.setText("");
            visitDatesField.setText("");
            reviewTextArea.setText("");
            setRating(0);

            JOptionPane.showMessageDialog(frame, "리뷰가 성공적으로 등록되었습니다!", "성공", JOptionPane.INFORMATION_MESSAGE);
        });
        panel.add(submitButton);

        // 리뷰 목록
        panel.add(new JLabel("등록된 리뷰 목록:"));
        reviewListPanel = new JPanel();
        reviewListPanel.setLayout(new BoxLayout(reviewListPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(reviewListPanel);
        scrollPane.setPreferredSize(new Dimension(550, 300));
        panel.add(scrollPane);

        frame.add(panel);
        frame.setVisible(true);
    }

    private JTextField addTextField(JPanel panel, String labelText) {
        panel.add(new JLabel(labelText));
        JTextField textField = new JTextField();
        panel.add(textField);
        return textField;
    }

    private JTextArea addTextArea(JPanel panel, String labelText) {
        panel.add(new JLabel(labelText));
        JTextArea textArea = new JTextArea(5, 30);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        panel.add(new JScrollPane(textArea));
        return textArea;
    }

    private JPanel createStarRatingPanel() {
        JPanel starPanel = new JPanel(new FlowLayout());
        List<JButton> starButtons = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            JButton starButton = new JButton("★");
            starButton.setFont(new Font("Arial", Font.PLAIN, 20));
            starButton.setForeground(Color.GRAY);
            final int currentRating = i;
            starButton.addActionListener(e -> {
                rating = currentRating;
                updateStarColors(starButtons, currentRating);
            });
            starButtons.add(starButton);
            starPanel.add(starButton);
        }
        return starPanel;
    }

    private void updateStarColors(List<JButton> starButtons, int selectedRating) {
        for (int i = 0; i < starButtons.size(); i++) {
            starButtons.get(i).setForeground(i < selectedRating ? Color.YELLOW : Color.GRAY);
        }
    }

    private void setRating(int rating) {
        this.rating = rating;
    }

    private void addReviewToList(EmployeeReview review) {
        JPanel reviewPanel = new JPanel();
        reviewPanel.setLayout(new BoxLayout(reviewPanel, BoxLayout.Y_AXIS));
        reviewPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        reviewPanel.setBackground(new Color(240, 240, 240));
        reviewPanel.setPreferredSize(new Dimension(550, 180));

        // 리뷰 내용 표시
        reviewPanel.add(new JLabel("구직자 이름: " + (review.getEmployee() != null ? review.getEmployee().getEmployeeName() : "없음")));
        reviewPanel.add(new JLabel("고용주 이름: " + (review.getEmployer() != null ? review.getEmployer().getEmployerName() : "없음")));
        reviewPanel.add(new JLabel("평점: " + "★".repeat((int) review.getRating())));
        reviewPanel.add(new JLabel("리뷰 내용: " + review.getContent()));

        // 수정 및 삭제 버튼
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton editButton = new JButton("수정");
        JButton deleteButton = new JButton("삭제");

        // 수정 버튼 동작
        editButton.addActionListener(e -> editReview(review, reviewPanel));

        // 삭제 버튼 동작
        deleteButton.addActionListener(e -> {
            reviews.remove(review);
            reviewListPanel.remove(reviewPanel);
            reviewListPanel.revalidate();
            reviewListPanel.repaint();
            JOptionPane.showMessageDialog(null, "리뷰가 삭제되었습니다.", "삭제", JOptionPane.INFORMATION_MESSAGE);
        });

        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        reviewPanel.add(buttonPanel);

        reviewListPanel.add(reviewPanel);
        reviewListPanel.revalidate();
        reviewListPanel.repaint();
    }

    private void editReview(EmployeeReview review, JPanel reviewPanel) {
        String newEmployeeName = JOptionPane.showInputDialog("구직자 이름:", review.getEmployee().getEmployeeName());
        String newEmployerName = JOptionPane.showInputDialog("고용주 이름:", review.getEmployer().getEmployerName());
        String newReviewContent = JOptionPane.showInputDialog("리뷰 내용:", review.getContent());

        if (newEmployeeName != null && newEmployerName != null && newReviewContent != null) {
            review.getEmployee().setEmployeeName(newEmployeeName);
            review.getEmployer().setEmployerName(newEmployerName);
            review.setContent(newReviewContent);

            reviewListPanel.remove(reviewPanel);
            addReviewToList(review);
            reviewListPanel.revalidate();
            reviewListPanel.repaint();
        }
    }
}
