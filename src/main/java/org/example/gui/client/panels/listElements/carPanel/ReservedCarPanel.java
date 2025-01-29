package org.example.gui.client.panels.listElements.carPanel;


import javax.swing.*;
import org.example.gui.client.dialogs.RentConfirmationDialog;
import org.example.gui.shared.panels.listElements.CarPanel;
import org.example.model.Car;

public class ReservedCarPanel extends CarPanel {
    public ReservedCarPanel(Car car) {
        super(car);
        JButton returnButton = new JButton("Wypożycz");
//        returnButton.addActionListener(e -> {
//            JDialog dialog = new RentConfirmationDialog();
//            dialog.setVisible(true);
//
//        });


        buttonPanel.add(returnButton);


    }

}
