package main.java.com.example.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class PaymentApp {

    public PaymentApp() {
        // 메인 프레임 생성
        JFrame frame = new JFrame("결제 시스템");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // 테이블 설정 (결제자 정보 표시)
        String[] columnNames = {"이름", "보유 게스트하우스", "결제 수단"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        // 결제 버튼 추가
        JButton paymentButton = new JButton("결제");
        frame.add(paymentButton, BorderLayout.SOUTH);

        // 결제 버튼 액션
        paymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 결제 입력 창 다이얼로그
                JDialog paymentDialog = new JDialog(frame, "결제 정보 입력", true);
                paymentDialog.setSize(300, 300);
                paymentDialog.setLayout(new GridLayout(5, 2));

                // 입력 필드 생성
                JLabel nameLabel = new JLabel("이름:");
                JTextField nameField = new JTextField();
                JLabel guesthouseLabel = new JLabel("보유 게스트하우스:");
                JSpinner guesthouseSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
                JLabel paymentMethodLabel = new JLabel("결제 수단:");
                String[] methods = {"신용카드", "카카오페이", "네이버페이", "계좌이체"};
                JComboBox<String> paymentMethodCombo = new JComboBox<>(methods);

                // 확인 및 취소 버튼
                JButton confirmButton = new JButton("확인");
                JButton cancelButton = new JButton("취소");

                // 다이얼로그에 컴포넌트 추가
                paymentDialog.add(nameLabel);
                paymentDialog.add(nameField);
                paymentDialog.add(guesthouseLabel);
                paymentDialog.add(guesthouseSpinner);
                paymentDialog.add(paymentMethodLabel);
                paymentDialog.add(paymentMethodCombo);
                paymentDialog.add(confirmButton);
                paymentDialog.add(cancelButton);

                // 확인 버튼 액션
                confirmButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // 입력값 가져오기
                        String name = nameField.getText();
                        int guesthouses = (int) guesthouseSpinner.getValue();
                        String paymentMethod = (String) paymentMethodCombo.getSelectedItem();

                        tableModel.addRow(new Object[]{name, guesthouses, paymentMethod});

                        // 다이얼로그 닫기
                        paymentDialog.dispose();
                    }
                });

                // 취소 버튼 액션
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        paymentDialog.dispose();
                    }
                });

                // 다이얼로그 표시
                paymentDialog.setVisible(true);
            }
        });

        // 메인 프레임 표시
        frame.setVisible(true);
    }
}