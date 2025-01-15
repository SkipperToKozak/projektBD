package org.example.gui.client.panels.listElements.carPanel;

import org.example.gui.client.dialogs.RentConfirmationDialog;
import org.example.gui.client.dialogs.ReservationConfirmationDialog;

import javax.swing.*;
import java.awt.*;

public class AvailableCarPanel extends CarPanel {
    private final JButton rentButton;
    private final JButton reserveButton;
    public AvailableCarPanel(String carBrand, String carModel, String carYear) {
        super(carBrand, carModel, carYear);
        rentButton = new JButton("Wypożycz");
        reserveButton = new JButton("Rezerwuj");
        buttonPanel.add(reserveButton);
        buttonPanel.add(rentButton);
        reserveButton.addActionListener(e -> {
            JDialog dialog = new ReservationConfirmationDialog();
            dialog.setVisible(true);
        });
        rentButton.addActionListener(e -> {
            JDialog dialog = new RentConfirmationDialog();
            dialog.setVisible(true);
        });

    }
}
