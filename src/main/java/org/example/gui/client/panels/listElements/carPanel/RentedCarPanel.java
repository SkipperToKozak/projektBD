package org.example.gui.client.panels.listElements.carPanel;

import org.example.gui.client.dialogs.ReturnConfirmationDialog;
import org.example.gui.shared.panels.listElements.CarPanel;
import org.example.model.Car;
import org.example.model.Rental;

import javax.swing.*;

public class RentedCarPanel extends CarPanel {
    public RentedCarPanel(Car car, Rental rental) {
        super(car);
        JButton returnButton = new JButton("Zwróć");
        buttonPanel.add(returnButton);
        returnButton.addActionListener(e -> {
            JDialog dialog = new ReturnConfirmationDialog();
            dialog.setVisible(true);

        });

        carStatusLabel.setText("Status wypożyczenia: " + rental.getStatus());


    }
}
