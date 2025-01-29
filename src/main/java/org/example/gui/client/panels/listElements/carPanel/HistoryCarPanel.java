package org.example.gui.client.panels.listElements.carPanel;

import org.example.gui.shared.panels.listElements.CarPanel;
import org.example.model.Car;
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
        rentDateLabel = new JLabel("Data wypożyczenia: " + rentDate);
        add(rentDateLabel, gbc);
        gbc.gridx = 1;
        returnDateLabel = new JLabel("Data zwrotu: " + returnDate);
        add(returnDateLabel, gbc);
    }
}
