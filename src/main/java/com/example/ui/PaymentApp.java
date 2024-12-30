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

        // 선택 해제 기능 추가
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int column = table.columnAtPoint(e.getPoint());
                if (row == -1 && column == -1) { // 테이블 외부 클릭 확인
                    table.clearSelection(); // 선택 해제
                }
            }
        });

        // 버튼 패널
        JPanel buttonPanel = new JPanel();
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // 결제 버튼 추가
        JButton paymentButton = new JButton("결제 등록");
        JButton editButton = new JButton("결제 수정");
        JButton deleteButton = new JButton("결제 삭제");

        buttonPanel.add(paymentButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        // 결제 등록 버튼 액션
        paymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openPaymentDialog(frame, tableModel, -1);
            }
        });

        // 결제 수정 버튼 액션
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(frame, "수정할 행을 선택하세요.", "오류", JOptionPane.ERROR_MESSAGE);
                } else {
                    openPaymentDialog(frame, tableModel, selectedRow);
                }
            }
        });

        // 결제 삭제 버튼 액션
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(frame, "삭제할 행을 선택하세요.", "오류", JOptionPane.ERROR_MESSAGE);
                } else {
                    int confirm = JOptionPane.showConfirmDialog(frame, "정말 삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        tableModel.removeRow(selectedRow);
                    }
                }
            }
        });

        // 메인 프레임 표시
        frame.setVisible(true);
    }

    private void openPaymentDialog(JFrame frame, DefaultTableModel tableModel, int rowIndex) {
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

        // 수정 모드일 경우 기존 데이터 로드
        if (rowIndex >= 0) {
            nameField.setText((String) tableModel.getValueAt(rowIndex, 0));
            guesthouseSpinner.setValue((int) tableModel.getValueAt(rowIndex, 1));
            paymentMethodCombo.setSelectedItem(tableModel.getValueAt(rowIndex, 2));
        }

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
                String name = nameField.getText();
                int guesthouses = (int) guesthouseSpinner.getValue();
                String paymentMethod = (String) paymentMethodCombo.getSelectedItem();

                if (rowIndex >= 0) {
                    // 수정 모드
                    tableModel.setValueAt(name, rowIndex, 0);
                    tableModel.setValueAt(guesthouses, rowIndex, 1);
                    tableModel.setValueAt(paymentMethod, rowIndex, 2);
                } else {
                    // 새로 추가 모드
                    tableModel.addRow(new Object[]{name, guesthouses, paymentMethod});
                }

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

    public static void main(String[] args) {
        new PaymentApp();
    }
}