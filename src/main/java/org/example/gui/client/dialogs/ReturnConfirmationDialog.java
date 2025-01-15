package org.example.gui.client.dialogs;

import javax.swing.*;

public class ReturnConfirmationDialog extends Dialog {
    public ReturnConfirmationDialog() {
        super("Potwierdzenie zwrotu");
        messageLabel.setText("Czy na pewno chcesz zwrócić ten samochód?");
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
