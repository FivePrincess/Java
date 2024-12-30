package main.java.com.example.ui;

import main.java.com.example.model.GuestHouse;
import main.java.com.example.model.Employer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GuestHouseController {
    private JPanel guesthouseListPanel;
    private List<GuestHouse> guesthouses;

    public GuestHouseController() {
        guesthouses = new ArrayList<>();

        JFrame frame = new JFrame("게스트하우스 관리 프로그램");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 700);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 게스트하우스 등록 UI
        JTextField nameField = addTextField(panel, "게스트하우스 이름:");
        JTextField locationField = addTextField(panel, "위치:");
        JTextField facilitiesField = addTextField(panel, "시설:");
        JTextField contactField = addTextField(panel, "연락처:");
        JTextField introField = addTextField(panel, "소개:");
        JTextField hashtagField = addTextField(panel, "해시태그 (쉼표로 구분):");
        JTextField imageField = addTextField(panel, "이미지 경로:");
        JTextField employerNameField = addTextField(panel, "고용주 이름:");

        // 등록 버튼
        JButton submitButton = new JButton("등록");
        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String location = locationField.getText();
            String facilities = facilitiesField.getText();
            String contact = contactField.getText();
            String intro = introField.getText();
            String hashtags = hashtagField.getText();
            String image = imageField.getText();
            String employerName = employerNameField.getText();

            if (name.isEmpty() || location.isEmpty() || facilities.isEmpty() || contact.isEmpty() || intro.isEmpty() || employerName.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "모든 필드를 입력해주세요!", "오류", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // GuestHouse 객체 생성 및 설정
            GuestHouse guesthouse = new GuestHouse();
            guesthouse.setGuesthouseName(name);
            guesthouse.setLocation(location);
            guesthouse.setFacilities(facilities);
            guesthouse.setContact(contact);
            guesthouse.setIntro(intro);
            guesthouse.setHashtag(hashtags.split(",\s*"));
            guesthouse.setImage(image);

            // Employer 객체 생성 및 설정
            Employer employer = new Employer();
            employer.setEmployerName(employerName);
            guesthouse.setEmployer(employer);

            // GuestHouse 목록에 추가
            guesthouses.add(guesthouse);
            addGuesthouseToList(guesthouse);

            // 입력 필드 초기화
            nameField.setText("");
            locationField.setText("");
            facilitiesField.setText("");
            contactField.setText("");
            introField.setText("");
            hashtagField.setText("");
            imageField.setText("");
            employerNameField.setText("");

            JOptionPane.showMessageDialog(frame, "게스트하우스가 성공적으로 등록되었습니다!", "성공", JOptionPane.INFORMATION_MESSAGE);
        });
        panel.add(submitButton);

        // 게스트하우스 목록
        panel.add(new JLabel("등록된 게스트하우스 목록:"));
        guesthouseListPanel = new JPanel();
        guesthouseListPanel.setLayout(new BoxLayout(guesthouseListPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(guesthouseListPanel);
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

    private void addGuesthouseToList(GuestHouse guesthouse) {
        JPanel guesthousePanel = new JPanel();
        guesthousePanel.setLayout(new BoxLayout(guesthousePanel, BoxLayout.Y_AXIS));
        guesthousePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        guesthousePanel.setBackground(new Color(240, 240, 240));
        guesthousePanel.setPreferredSize(new Dimension(550, 150));

        // 게스트하우스 정보 표시
        guesthousePanel.add(new JLabel("이름: " + guesthouse.getGuesthouseName()));
        guesthousePanel.add(new JLabel("위치: " + guesthouse.getLocation()));
        guesthousePanel.add(new JLabel("시설: " + guesthouse.getFacilities()));
        guesthousePanel.add(new JLabel("연락처: " + guesthouse.getContact()));
        guesthousePanel.add(new JLabel("소개: " + guesthouse.getIntro()));
        guesthousePanel.add(new JLabel("해시태그: " + String.join(", ", guesthouse.getHashtag())));
        guesthousePanel.add(new JLabel("고용주 이름: " + (guesthouse.getEmployer() != null ? guesthouse.getEmployer().getEmployerName() : "없음")));

        // 수정 및 삭제 버튼
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton editButton = new JButton("수정");
        JButton deleteButton = new JButton("삭제");

        // 수정 버튼 동작
        editButton.addActionListener(e -> editGuesthouse(guesthouse, guesthousePanel));

        // 삭제 버튼 동작
        deleteButton.addActionListener(e -> {
            guesthouses.remove(guesthouse);
            guesthouseListPanel.remove(guesthousePanel);
            guesthouseListPanel.revalidate();
            guesthouseListPanel.repaint();
            JOptionPane.showMessageDialog(null, "게스트하우스가 삭제되었습니다.", "삭제", JOptionPane.INFORMATION_MESSAGE);
        });

        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        guesthousePanel.add(buttonPanel);

        guesthouseListPanel.add(guesthousePanel);
        guesthouseListPanel.revalidate();
        guesthouseListPanel.repaint();
    }

    private void editGuesthouse(GuestHouse guesthouse, JPanel guesthousePanel) {
        String newName = JOptionPane.showInputDialog("게스트하우스 이름:", guesthouse.getGuesthouseName());
        String newLocation = JOptionPane.showInputDialog("위치:", guesthouse.getLocation());
        String newFacilities = JOptionPane.showInputDialog("시설:", guesthouse.getFacilities());
        String newContact = JOptionPane.showInputDialog("연락처:", guesthouse.getContact());
        String newIntro = JOptionPane.showInputDialog("소개:", guesthouse.getIntro());
        String newHashtags = JOptionPane.showInputDialog("해시태그 (쉼표로 구분):", String.join(", ", guesthouse.getHashtag()));

        if (newName != null && newLocation != null && newFacilities != null && newContact != null && newIntro != null && newHashtags != null) {
            guesthouse.setGuesthouseName(newName);
            guesthouse.setLocation(newLocation);
            guesthouse.setFacilities(newFacilities);
            guesthouse.setContact(newContact);
            guesthouse.setIntro(newIntro);
            guesthouse.setHashtag(newHashtags.split(",\s*"));

            guesthouseListPanel.remove(guesthousePanel);
            addGuesthouseToList(guesthouse);
            guesthouseListPanel.revalidate();
            guesthouseListPanel.repaint();
        }
    }
}