package org.example.gui.client.dialogs;

import javax.swing.*;

public class RentConfirmationDialog extends Dialog {
    public RentConfirmationDialog() {
        super("Potwierdzenie wypożyczenia");
        messageLabel.setText("Czy na pewno chcesz wypożyczyć ten samochód?");
        JButton confirmButton = new JButton("Potwierdź");
        JButton cancelButton = new JButton("Anuluj");

        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);
        confirmButton.addActionListener(e -> dispose());
        cancelButton.addActionListener(e -> dispose());
    }
}
