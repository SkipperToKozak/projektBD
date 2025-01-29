package org.example.gui.client.dialogs;

import org.example.gui.shared.dialogs.Dialog;
import org.example.model.Car;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ReturnConfirmationDialog extends Dialog {
    private JButton confirmButton;
    private JButton cancelButton;
    public ReturnConfirmationDialog(Car car) {
        super("Potwierdzenie zwrotu");
        messageLabel.setText("Czy na pewno chcesz zwrócić ten samochód?");
        confirmButton = new JButton("Potwierdź");
        cancelButton = new JButton("Anuluj");

        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);
        confirmButton.addActionListener(e -> {
            dispose();
        });
        cancelButton.addActionListener(e -> {
            dispose();
        });
    }
    public void setReturnConfirmButtonListener(ActionListener listener) {
        confirmButton.addActionListener(listener);
    }

}
