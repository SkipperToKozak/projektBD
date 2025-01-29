package org.example.gui.client.dialogs;

import org.example.gui.shared.dialogs.Dialog;
import org.example.model.Car;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ReservationConfirmationDialog extends Dialog {
    private Car car;
    private JButton confirmButton = new JButton("Potwierdź");
    private JButton cancelButton = new JButton("Anuluj");
    public ReservationConfirmationDialog(Car car) {
        super("Potwierdzenie rezerwacji");
        messageLabel.setText("Czy na pewno chcesz zarezerwować ten samochód?");


        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);
        confirmButton.addActionListener(e -> {
            dispose();
        });
        cancelButton.addActionListener(e -> {
            dispose();
        });
    }
    public void setReservationConfirmButtonDialogListener(ActionListener listener) {
        confirmButton.addActionListener(listener);
    }
    public void setReservationCancelButtonDialogListener(ActionListener listener) {
        cancelButton.addActionListener(listener);
    }
}
