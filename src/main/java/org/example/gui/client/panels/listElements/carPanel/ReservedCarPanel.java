package org.example.gui.client.panels.listElements.carPanel;


import javax.swing.*;
import org.example.gui.client.dialogs.RentConfirmationDialog;
import org.example.gui.shared.panels.listElements.CarPanel;

public class ReservedCarPanel extends CarPanel {
    public ReservedCarPanel(String carBrand, String carModel, String carYear) {
        super(carBrand, carModel, carYear);
        JButton returnButton = new JButton("Wypożycz");
        returnButton.addActionListener(e -> {
            JDialog dialog = new RentConfirmationDialog();
            dialog.setVisible(true);

        });


        buttonPanel.add(returnButton);


    }

}
