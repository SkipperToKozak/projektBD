package org.example.gui.client.panels.listElements.carPanel;

import org.example.gui.shared.panels.listElements.CarPanel;
import org.example.model.Car;
import org.example.model.Rental;
import org.example.model.Reservation;

import javax.swing.*;
import java.awt.*;

public class HistoryCarPanel extends CarPanel {
    private JLabel rentDateLabel;
    private String rentDate;
    private JLabel returnDateLabel;
    private String returnDate;

    public HistoryCarPanel(Car car, Reservation reservation){
        super(car);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.gridx = 0;
        gbc.gridy = 2;
        rentDateLabel = new JLabel("Data wypożyczenia: " + reservation.getStartDate());
        add(rentDateLabel, gbc);
        gbc.gridx = 1;
        returnDateLabel = new JLabel("Data zwrotu: " + reservation.getEndDate());
        add(returnDateLabel, gbc);
        carStatusLabel.setText("Status rezerwacji: " + reservation.getStatus());
    }

    public HistoryCarPanel(Car car, Rental rental) {
        super(car);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.gridx = 0;
        gbc.gridy = 2;
        rentDateLabel = new JLabel("Data wypożyczenia: " + rental.getStartDate());
        add(rentDateLabel, gbc);
        gbc.gridx = 1;
        returnDateLabel = new JLabel("Data zwrotu: " + rental.getEndDate());
        add(returnDateLabel, gbc);
        carStatusLabel.setText("Status wypożyczenia: " + rental.getStatus());
    }
}
