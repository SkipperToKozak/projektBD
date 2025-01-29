package org.example.gui.shared;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends JFrame {
    private JButton OKButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel consoleLogLabel;
    private JLabel registerLabel;
    private JPanel mainPanel;

    public LoginForm() {

        setTitle("Logowanie");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        // Tworzenie komponentów
        mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        usernameField = new JTextField();
        passwordField = new JPasswordField();
        OKButton = new JButton("Zaloguj");
        consoleLogLabel = new JLabel(" ", SwingConstants.CENTER);
        registerLabel = new JLabel("Nie masz jeszcze konta? Zarejestruj się.", SwingConstants.CENTER);
        registerLabel.setForeground(Color.BLACK);

        // Ustawienia GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(new JLabel("Nazwa użytkownika:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(new JLabel("Hasło:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        mainPanel.add(OKButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        mainPanel.add(registerLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        mainPanel.add(consoleLogLabel, gbc);

        // Dodanie efektu zmiany koloru na niebieski po najechaniu myszką
        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                registerLabel.setForeground(Color.BLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                registerLabel.setForeground(Color.BLACK);
            }
        });


        // Ustawienie panelu jako głównego kontenera
        setContentPane(mainPanel);
    }

    public void setOKButtonActionListener(ActionListener actionListener) {
        OKButton.addActionListener(actionListener);
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JLabel getConsoleLogLabel() {
        return consoleLogLabel;
    }
    public JLabel getRegisterLabel() {
        return registerLabel;
    }
}
