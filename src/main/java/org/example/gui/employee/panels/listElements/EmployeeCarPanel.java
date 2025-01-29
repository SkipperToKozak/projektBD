package org.example.gui.employee.panels.listElements;

import org.example.gui.client.dialogs.ReturnConfirmationDialog;
import org.example.gui.employee.dialogs.UpdateCarDialog;
import org.example.gui.shared.panels.listElements.CarPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Objects;

public class EmployeeCarPanel extends CarPanel {

    private JButton updateButton;
    private JButton blockButton;
    private JButton unblockButton;
    private JButton deleteButton;


    private String status;

    public EmployeeCarPanel(String carBrand, String carModel, String carYear, String status) {
        super(carBrand, carModel, carYear);
        this.status = status;

        deleteButton = new JButton("Usuń");
        unblockButton = new JButton("Odblokuj");
        updateButton = new JButton("Aktualizuj");
        blockButton = new JButton("Zablokuj");

        updateStatus();

        buttonPanel.add(updateButton);
        buttonPanel.add(blockButton);
        buttonPanel.add(unblockButton);
        buttonPanel.add(deleteButton);

        updateButton.addActionListener(e -> {
            UpdateCarDialog updateCarDialog = new UpdateCarDialog(carBrand, carModel, carYear, "1212", "dostepny", "czerw",
                    "5", "120", "12000", "12.12.1212");
            updateCarDialog.setVisible(true);
        });

        blockButton.addActionListener(e -> {
            setStatus("zablokowany");
            updateStatus();
        });

        unblockButton.addActionListener(e -> {

        });

    }
    public void updateStatus(){
        if (Objects.equals(status, "zablokowany")) {
            //jesli status jest zablokowany
            setBackground(Color.RED);
            buttonPanel.setBackground(Color.RED);
            blockButton.setEnabled(false);
            unblockButton.setEnabled(true);
            updateButton.setEnabled(true);
            deleteButton.setEnabled(true);
        }
        else if (Objects.equals(status, "wypozyczony") || Objects.equals(status, "zarezerwowany")) {
            //jesli status jest wypozyczony
            setBackground(Color.YELLOW);
            buttonPanel.setBackground(Color.YELLOW);
            blockButton.setEnabled(false);
            unblockButton.setEnabled(false);
            updateButton.setEnabled(false);
            deleteButton.setEnabled(false);

        }
        else if (Objects.equals(status, "usuniety")) {
            //jesli status jest dostepny
            blockButton.setEnabled(true);
            setBackground(Color.DARK_GRAY);
            setLabelsForeground(Color.WHITE);
            buttonPanel.setBackground(Color.DARK_GRAY);
            buttonPanel.setForeground(Color.WHITE);
            unblockButton.setEnabled(false);
            updateButton.setEnabled(false);
            deleteButton.setEnabled(false);

        } else {//jesli status jest dostepny
            blockButton.setEnabled(true);
            setBackground(Color.GREEN);
            buttonPanel.setBackground(Color.GREEN);
            unblockButton.setEnabled(false);
            updateButton.setEnabled(false);
            deleteButton.setEnabled(false);
        }
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void setUpdateButtonListener(ActionListener listener) {
        updateButton.addActionListener(listener);
    }
    public void setBlockButtonListener(ActionListener listener) {
        blockButton.addActionListener(listener);
    }
    public void setUnblockButtonListener(ActionListener listener) {
        unblockButton.addActionListener(listener);
    }
    public void setDeleteButtonListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }


}
