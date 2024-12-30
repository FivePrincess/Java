import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserManagementApp {
    private JFrame frame;
    private JTextField txtId, txtName, txtRole, txtAdditionalInfo;
    private JButton btnRegister, btnUpdate, btnRetrieve;

    public UserManagementApp() {
        // Main Frame
        frame = new JFrame("User Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(6, 2, 10, 10));

        // Components
        JLabel lblId = new JLabel("ID:");
        txtId = new JTextField();

        JLabel lblName = new JLabel("Name:");
        txtName = new JTextField();

        JLabel lblRole = new JLabel("Role:");
        txtRole = new JTextField();

        JLabel lblAdditionalInfo = new JLabel("Additional Info:");
        txtAdditionalInfo = new JTextField();

        btnRegister = new JButton("Register");
        btnUpdate = new JButton("Update");
        btnRetrieve = new JButton("Retrieve");

        // Adding components to the frame
        frame.add(lblId);
        frame.add(txtId);

        frame.add(lblName);
        frame.add(txtName);

        frame.add(lblRole);
        frame.add(txtRole);

        frame.add(lblAdditionalInfo);
        frame.add(txtAdditionalInfo);

        frame.add(btnRegister);
        frame.add(btnUpdate);
        frame.add(btnRetrieve);

        // Action Listeners
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateUser();
            }
        });

        btnRetrieve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retrieveUser();
            }
        });

        // Display the frame
        frame.setVisible(true);
    }

    private void registerUser() {
        String id = txtId.getText();
        String name = txtName.getText();
        String role = txtRole.getText();
        String additionalInfo = txtAdditionalInfo.getText();

        JOptionPane.showMessageDialog(frame, "User Registered:\nID: " + id + "\nName: " + name + "\nRole: " + role + "\nInfo: " + additionalInfo);
        clearFields();
    }

    private void updateUser() {
        String id = txtId.getText();
        String name = txtName.getText();
        String role = txtRole.getText();
        String additionalInfo = txtAdditionalInfo.getText();

        JOptionPane.showMessageDialog(frame, "User Updated:\nID: " + id + "\nName: " + name + "\nRole: " + role + "\nInfo: " + additionalInfo);
        clearFields();
    }

    private void retrieveUser() {
        String id = txtId.getText();

        // Simulate data retrieval
        JOptionPane.showMessageDialog(frame, "Retrieved User:\nID: " + id + "\nName: John Doe\nRole: Employer\nInfo: Business Owner");
        clearFields();
    }

    private void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtRole.setText("");
        txtAdditionalInfo.setText("");
    }

    public static void main(String[] args) {
        new UserManagementApp();
    }
}
