package org.example.gui.client.panels.listElements.carPanel;

import org.example.gui.client.dialogs.RentConfirmationDialog;
import org.example.gui.client.dialogs.ReservationConfirmationDialog;
import org.example.gui.shared.panels.listElements.CarPanel;

import javax.swing.*;
import java.awt.event.ActionListener;

public class AvailableCarPanel extends CarPanel {
    private final JButton rentButton;
    private final JButton reserveButton;
    public AvailableCarPanel(String carBrand, String carModel, String carYear) {
        super(carBrand, carModel, carYear);
        rentButton = new JButton("Wypożycz");
        reserveButton = new JButton("Rezerwuj");
        buttonPanel.add(reserveButton);
        buttonPanel.add(rentButton);



    }
    public void setReserveButtonListener(ActionListener listener) {
        reserveButton.addActionListener(listener);
    }
    public void setRentButtonListener(ActionListener listener) {
        rentButton.addActionListener(listener);
    }

}
