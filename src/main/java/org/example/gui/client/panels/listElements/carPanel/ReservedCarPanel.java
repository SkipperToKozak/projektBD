package org.example.gui.client.panels.listElements.carPanel;


import javax.swing.*;
import org.example.gui.client.dialogs.RentConfirmationDialog;
import org.example.gui.shared.panels.listElements.CarPanel;
import org.example.model.Car;
import org.example.model.Reservation;

import java.awt.event.ActionListener;

public class ReservedCarPanel extends CarPanel {
    JButton rentButton;

    public ReservedCarPanel(Car car, Reservation reservation) {
        super(car);
        rentButton = new JButton("Wypożycz");
//        rentButton.addActionListener(e -> {
//            JDialog dialog = new RentConfirmationDialog(car);
//            dialog.setVisible(true);
//
//        });


        buttonPanel.add(rentButton);

        carStatusLabel.setText("Status rezerwacji: " + reservation.getStatus());


    }

    public void setReserveButtonListener(ActionListener listener) {
        rentButton.addActionListener(listener);
    }

}
