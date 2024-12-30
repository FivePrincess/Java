package main.java.com.example.ui;

import javax.swing.*;
import java.awt.*;

public class MainUI {
    private JFrame frame;

    public MainUI() {
        // 메인 프레임 설정
        frame = new JFrame("메인 화면");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(2, 2, 10, 10)); // 2x2 그리드 레이아웃

        // 버튼 생성
        JButton btnResume = new JButton("이력서 조회");
        JButton btnReview = new JButton("리뷰 작성");
        JButton btnSubscribe = new JButton("구독");
        JButton btnGuesthouse = new JButton("게스트하우스");

        // 버튼 이벤트 처리
        btnResume.addActionListener(e -> openResume());
        btnReview.addActionListener(e -> openReview());
        btnSubscribe.addActionListener(e -> openSubscribe());
        btnGuesthouse.addActionListener(e -> openGuesthouse());

        // 버튼 추가
        frame.add(btnResume);
        frame.add(btnReview);
        frame.add(btnSubscribe);
        frame.add(btnGuesthouse);

        // 프레임 표시
        frame.setVisible(true);
    }

    private void openResume() {
        new ResumeApp();
    }

    private void openReview() {
        new ReviewController(); // 새로운 프레임으로 리뷰 작성 화면 열기
    }

    private void openSubscribe() {
        new PaymentApp();
    }

    private void openGuesthouse() {
        JOptionPane.showMessageDialog(frame, "게스트하우스 화면 열림 (구현 예정)");
    }
}
