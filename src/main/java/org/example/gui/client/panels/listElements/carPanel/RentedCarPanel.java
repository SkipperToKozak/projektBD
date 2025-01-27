package org.example.gui.client.panels.listElements.carPanel;

import org.example.gui.client.dialogs.ReturnConfirmationDialog;
import org.example.gui.shared.panels.listElements.CarPanel;

import javax.swing.*;

public class RentedCarPanel extends CarPanel {
    public RentedCarPanel(String carBrand, String carModel, String carYear) {
        super(carBrand, carModel, carYear);
        JButton returnButton = new JButton("Zwróć");
        buttonPanel.add(returnButton);
        returnButton.addActionListener(e -> {
            JDialog dialog = new ReturnConfirmationDialog();
            dialog.setVisible(true);

        });


    }
}
