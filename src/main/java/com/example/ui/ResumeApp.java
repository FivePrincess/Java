package main.java.com.example.ui;

import main.java.com.example.model.Resume;
import main.java.com.example.model.WorkExperience;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ResumeApp extends JFrame {
    private ArrayList<Resume> resumes = new ArrayList<>();
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> resumeList = new JList<>(listModel);

    public ResumeApp() {
        setTitle("이력서 리스트");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JButton addButton = new JButton("추가");
        JButton editButton = new JButton("수정");
        JButton detailButton = new JButton("상세보기");
        JButton deleteButton = new JButton("삭제");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(detailButton);
        buttonPanel.add(deleteButton);

        add(new JScrollPane(resumeList), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        refreshResumeList();

        addButton.addActionListener(e -> showFormDialog(new Resume("0", "", "", "", ""), false));
        editButton.addActionListener(e -> {
            int selectedIndex = resumeList.getSelectedIndex();
            if (selectedIndex != -1) {
                Resume resume = resumes.get(selectedIndex);
                showFormDialog(resume, true);
            } else {
                JOptionPane.showMessageDialog(this, "수정할 이력서를 선택하세요.", "오류", JOptionPane.ERROR_MESSAGE);
            }
        });

        detailButton.addActionListener(e -> {
            int selectedIndex = resumeList.getSelectedIndex();
            if (selectedIndex != -1) {
                Resume resume = resumes.get(selectedIndex);
                JOptionPane.showMessageDialog(this, resume.toDetailString(), "이력서 상세보기", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        deleteButton.addActionListener(e -> {
            int selectedIndex = resumeList.getSelectedIndex();
            if (selectedIndex != -1) {
                resumes.remove(selectedIndex);
                listModel.remove(selectedIndex);
                refreshResumeList();
                JOptionPane.showMessageDialog(this, "이력서가 성공적으로 삭제되었습니다.");
            }
        });

        setVisible(true);
    }

    private void refreshResumeList() {
        listModel.clear();
        if (resumes.isEmpty()) {
            listModel.addElement("아직 등록된 이력서가 없습니다.");
        } else {
            for (Resume resume : resumes) {
                listModel.addElement(resume.getTitle());
            }
        }
    }

    private void showFormDialog(Resume resume, boolean isEdit) {
        JDialog dialog = new JDialog(this, isEdit ? "이력서 수정" : "이력서 추가", true);
        dialog.setSize(400, 600);
        dialog.setLayout(new GridLayout(12, 2));

        JTextField titleField = new JTextField(resume.getTitle());
        JTextField addressField = new JTextField(resume.getAddress());
        JTextField phoneField = new JTextField(resume.getPhoneNumber());
        JTextField instagramField = new JTextField(resume.getInstagram());
        JTextField workPlaceField = new JTextField();
        JTextField workContentField = new JTextField();
        JTextField startDateField = new JTextField("yyyy-MM-dd");
        JTextField endDateField = new JTextField("yyyy-MM-dd");

        dialog.add(new JLabel("제목:"));
        dialog.add(titleField);
        dialog.add(new JLabel("주소:"));
        dialog.add(addressField);
        dialog.add(new JLabel("전화번호:"));
        dialog.add(phoneField);
        dialog.add(new JLabel("인스타그램:"));
        dialog.add(instagramField);

        if (!resume.getWorkExperience().isEmpty()) {
            WorkExperience lastExp = resume.getWorkExperience().get(resume.getWorkExperience().size() - 1);
            workPlaceField.setText(lastExp.getWorkplaceName());
            workContentField.setText(lastExp.getWorkContent());
            startDateField.setText(new SimpleDateFormat("yyyy-MM-dd").format(lastExp.getStartDate()));
            endDateField.setText(new SimpleDateFormat("yyyy-MM-dd").format(lastExp.getEndDate()));
        }

        dialog.add(new JLabel("직장명:"));
        dialog.add(workPlaceField);
        dialog.add(new JLabel("업무 내용:"));
        dialog.add(workContentField);
        dialog.add(new JLabel("시작 날짜:"));
        dialog.add(startDateField);
        dialog.add(new JLabel("종료 날짜:"));
        dialog.add(endDateField);

        JButton saveButton = new JButton("저장");
        dialog.add(saveButton);

        saveButton.addActionListener(e -> {
            resume.setTitle(titleField.getText());
            resume.setAddress(addressField.getText());
            resume.setPhoneNumber(phoneField.getText());
            resume.setInstagram(instagramField.getText());

            try {
                Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDateField.getText());
                Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateField.getText());
                int newId = resume.getWorkExperience().size() + 1;
                WorkExperience workExperience = new WorkExperience(newId, workPlaceField.getText(), startDate, endDate, workContentField.getText());
                resume.addWorkExperience(workExperience);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "유효하지 않은 날짜 형식입니다.", "오류", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!isEdit) {
                resumes.add(resume);
            }
            refreshResumeList();
            dialog.dispose();
        });

        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ResumeApp::new);
    }
}
