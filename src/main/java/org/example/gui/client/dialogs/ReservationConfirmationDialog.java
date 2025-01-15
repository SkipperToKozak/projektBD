package org.example.gui.client.dialogs;

import javax.swing.*;

public class ReservationConfirmationDialog extends Dialog{
    public ReservationConfirmationDialog() {
        super("Potwierdzenie rezerwacji");
        messageLabel.setText("Czy na pewno chcesz zarezerwować ten samochód?");
        JButton confirmButton = new JButton("Potwierdź");
        JButton cancelButton = new JButton("Anuluj");

        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);
        confirmButton.addActionListener(e -> {
            dispose();
        });
        cancelButton.addActionListener(e -> {
            dispose();
        });
    }
}
