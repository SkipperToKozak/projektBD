package org.example.gui.client.panels;

import javax.swing.*;
import java.awt.*;

public class ClientAccountPanel extends JPanel {
    private final JLabel titleLabel;
    private final JLabel nameLabel;
    private final JLabel surnameLabel;
    private final JLabel peselLabel;

    public ClientAccountPanel(String name, String surname, String pesel) {
        // Duży tytuł
        titleLabel = new JLabel("Moje Konto");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Duża czcionka
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Informacje o kliencie
        nameLabel = new JLabel("Imię: " + name);
        surnameLabel = new JLabel("Nazwisko: " + surname);
        peselLabel = new JLabel("PESEL: " + pesel);

        // Ustawienie wyrównania
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        surnameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        peselLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Układ i marginesy
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Dodanie elementów do panelu
        add(titleLabel);
        add(Box.createVerticalStrut(20)); // Odstęp między tytułem a informacjami
        add(nameLabel);
        add(Box.createVerticalStrut(10));
        add(surnameLabel);
        add(Box.createVerticalStrut(10));
        add(peselLabel);

        setVisible(true);
    }
}
