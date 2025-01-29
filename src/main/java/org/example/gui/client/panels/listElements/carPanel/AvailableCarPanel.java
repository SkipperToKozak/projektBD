package org.example.gui.client.panels.listElements.carPanel;

import org.example.gui.client.dialogs.RentConfirmationDialog;
import org.example.gui.client.dialogs.ReservationConfirmationDialog;
import org.example.gui.shared.panels.listElements.CarPanel;
import org.example.model.Car;

import javax.swing.*;
import java.awt.event.ActionListener;

public class AvailableCarPanel extends CarPanel {
    private final JButton rentButton;
    private final JButton reserveButton;
    private RentConfirmationDialog rentConfirmationDialog;
    public AvailableCarPanel(Car car) {
        super(car);
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
