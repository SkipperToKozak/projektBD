package org.example.gui.employee.dialogs;

import org.example.gui.employee.panels.ClientCarsListPanel;

import javax.swing.*;

public class ClientCarsListDialog extends JDialog {
    public ClientCarsListDialog() {
        super();
        setTitle("Lista samochodów klienta");
        setSize(500, 500);
        setResizable(false);
        setModal(true);
//        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        add(new ClientCarsListPanel());
    }
}
