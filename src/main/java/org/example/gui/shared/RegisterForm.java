package org.example.gui.shared;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegisterForm extends JFrame {
    private JButton registerButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JTextField peselField;
    private JTextField nameField;
    private JTextField surnameField;
    private JLabel consoleLogLabel;
    private JPanel mainPanel;

    public RegisterForm() {
        setTitle("Rejestracja");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);
        setLocationRelativeTo(null);
        setResizable(false);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{100, 100};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
        // Tworzenie komponentów
        mainPanel = new JPanel(gridBagLayout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        usernameField = new JTextField();
        peselField = new JTextField();
        nameField = new JTextField();
        surnameField = new JTextField();
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();
        registerButton = new JButton("Zarejestruj");
        consoleLogLabel = new JLabel(" ", SwingConstants.CENTER);

        // Ustawienia GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(new JLabel("Nazwa użytkownika:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(usernameField, gbc);



        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(new JLabel("Imię:"), gbc);


        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(nameField, gbc);



        gbc.gridx = 0;
        gbc.gridy = 2;
//        mainPanel.add(new JLabel("Hasło:"), gbc);
        mainPanel.add(new JLabel("Nazwisko:"), gbc);


        gbc.gridx = 1;
        gbc.gridy = 2;
//        mainPanel.add(passwordField, gbc);
        mainPanel.add(surnameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(new JLabel("PESEL:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        mainPanel.add(peselField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(new JLabel("Hasło:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        mainPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        mainPanel.add(registerButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        mainPanel.add(consoleLogLabel, gbc);

        // Ustawienie panelu jako głównego kontenera
        setContentPane(mainPanel);

        setVisible(true);
    }

    public void setRegisterButtonActionListener(ActionListener actionListener) {
        registerButton.addActionListener(actionListener);
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JTextField getPeselField() {
        return peselField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getSurnameField() {
        return surnameField;
    }

    public JLabel getConsoleLogLabel() {
        return consoleLogLabel;
    }
}
