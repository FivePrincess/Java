package main.java.com.example.ui;

import main.java.com.example.model.Employee;
import main.java.com.example.model.Employer;
import main.java.com.example.model.UserRole;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JFrame frame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainUI());
    }
}
