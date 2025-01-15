package org.example.gui.client.panels.listElements.carPanel;

import javax.swing.*;
import java.awt.*;

public class HistoryCarPanel extends CarPanel {
    private JLabel rentDateLabel;
    private String rentDate;
    private JLabel returnDateLabel;
    private String returnDate;

    public HistoryCarPanel(String carBrand, String carModel, String carYear, String rentDate, String returnDate) {
        super(carBrand, carModel, carYear);
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
