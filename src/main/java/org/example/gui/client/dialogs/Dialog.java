package org.example.gui.client.dialogs;

import javax.swing.*;
import java.awt.*;

public abstract class Dialog extends JDialog {
    protected JPanel buttonPanel;
    protected JLabel messageLabel;
    public Dialog(String title) {
        super();
        setTitle(title);
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[]{0};
        layout.rowHeights = new int[]{0, 0};
        setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        messageLabel = new JLabel();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(messageLabel, gbc);


        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 10, 10);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        add(buttonPanel, gbc);
    }
}
