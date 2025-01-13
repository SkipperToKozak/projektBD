package org.example.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class LoginForm {
    private JButton OKButton;
    private JTextField usernameField;
    private JTextField passwordField;
    private JLabel consoleLogLabel;
    private javax.swing.JPanel JPanel;
    private JTextPane resultsPanel;
    private JTextField commandsPanel;
    private JButton sendButton;
    private JTextPane textPane1;

    public LoginForm() {
        JFrame frame = new JFrame("LoginForm");
        frame.setContentPane(JPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:postgresql://localhost:5432/test1";

                try (Connection connection = DriverManager.getConnection(url, usernameField.getText(), passwordField.getText())) {
                    System.out.println("Połączono z bazą danych PostgreSQL!");
                    consoleLogLabel.setText("Połączono z bazą danych PostgreSQL!");



                } catch (SQLException e1) {
                    System.err.println("Nie udało się połączyć: " + e1.getMessage());
                    consoleLogLabel.setText("Nie udało się połączyć: " + e1.getMessage());
                }

            }
        });
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:postgresql://localhost:5432/test1";

                try (Connection connection = DriverManager.getConnection(url, usernameField.getText(), passwordField.getText())) {
                    System.out.println("Połączono z bazą danych PostgreSQL!");
                    consoleLogLabel.setText("Połączono z bazą danych PostgreSQL!");

                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(commandsPanel.getText());
                    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                    int columnsNumber = resultSetMetaData.getColumnCount();
                    String results = "";
                    while (resultSet.next()) {
                        for (int i = 1; i <= columnsNumber; i++) {
                            if (i > 1) results += ",  ";
                            String columnValue = resultSet.getString(i);
                            results += resultSetMetaData.getColumnName(i) + ": " + columnValue;
                        }
                        results += "\n";
                    }
                    resultsPanel.setText(results);

                } catch (SQLException e1) {
                    System.err.println("Nie udało się połączyć: " + e1.getMessage());
                    consoleLogLabel.setText("Nie udało się połączyć: " + e1.getMessage());
                }
            }
        });
    }
}
