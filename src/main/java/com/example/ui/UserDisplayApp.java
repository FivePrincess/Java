package main.java.com.example.ui;

import main.java.com.example.model.Employee;
import main.java.com.example.model.Employer;
import main.java.com.example.model.UserRole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserDisplayApp {

    public static void main(String[] args) {
        // 메인 프레임 생성
        JFrame frame = new JFrame("User Display Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout());

        // Display 영역
        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false); // 텍스트 수정 불가
        JScrollPane scrollPane = new JScrollPane(displayArea);

        // 버튼 패널
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        // Employer 버튼
        JButton btnEmployer = new JButton("Show Employer");
        btnEmployer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Employer employer = new Employer();
                employer.setEmployerName("John Doe");
                employer.setEmployerPhoneNumber("123-456-7890");
                employer.setBusinessLicenseNumber("987654321");
                employer.setRole(UserRole.EMPLOYER);

                // Display employer 정보
                displayArea.setText("");
                displayArea.append("Employer Information:\n");
                displayArea.append("Name: " + employer.getEmployerName() + "\n");
                displayArea.append("Phone: " + employer.getEmployerPhoneNumber() + "\n");
                displayArea.append("Business License: " + employer.getBusinessLicenseNumber() + "\n");
                displayArea.append("Role: " + employer.getRole() + "\n");
            }
        });

        // Employee 버튼
        JButton btnEmployee = new JButton("Show Employee");
        btnEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Employee employee = new Employee();
                employee.setEmployeeName("Jane Smith");
                employee.setAge(28);
                employee.setProfile("Software Engineer");
                employee.setMbti("INTJ");
                employee.setInstagram("@janesmith");
                employee.setHashtag(new String[]{"developer", "java", "swing"});

                // Display employee 정보
                displayArea.setText("");
                displayArea.append("Employee Information:\n");
                displayArea.append("Name: " + employee.getEmployeeName() + "\n");
                displayArea.append("Age: " + employee.getAge() + "\n");
                displayArea.append("Profile: " + employee.getProfile() + "\n");
                displayArea.append("MBTI: " + employee.getMbti() + "\n");
                displayArea.append("Instagram: " + employee.getInstagram() + "\n");
                displayArea.append("Hashtags: " + String.join(", ", employee.getHashtag()) + "\n");
            }
        });

        // 버튼 패널에 버튼 추가
        buttonPanel.add(btnEmployer);
        buttonPanel.add(btnEmployee);

        // 메인 프레임에 컴포넌트 추가
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // 프레임 표시
        frame.setVisible(true);
    }
}
