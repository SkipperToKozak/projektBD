package org.example.gui.employee.dialogs;

//import org.example.gui.shared.dialogs.DatePicker;
import org.example.gui.shared.dialogs.Dialog;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePickerImpl;
import org.example.gui.shared.dialogs.DatePickerExample;

import javax.swing.*;
import java.awt.*;

public class AddCarDialog extends JDialog
{
    private JLabel brandLabel = new JLabel("Marka");
    private JTextField brandField = new JTextField();
    private JLabel modelLabel = new JLabel("Model");
    private JTextField modelField = new JTextField();
    private JLabel idLabel = new JLabel("Numer rejestracyjny");
    private JTextField idField = new JTextField();
    private JLabel yearLabel = new JLabel("Rok produkcji");
    private JTextField yearField = new JTextField();
    private JLabel statusLabel = new JLabel("Status");
    private JTextField statusField = new JTextField();
    private JLabel colorLabel = new JLabel("Kolor");
    private JTextField colorField = new JTextField();
    private JLabel seatsLabel = new JLabel("Ilość miejsc");
    private JTextField seatsField = new JTextField();
    private JLabel horsePowerLabel = new JLabel("Moc");
    private JTextField horsePowerField = new JTextField();
    private JLabel mileageLabel = new JLabel("Przebieg");
    private JTextField mileageField = new JTextField();
    private JLabel dateOfServiceLabel = new JLabel("Data ostatniego przegladu");
    private JTextField dateOfServiceField = new JTextField();
    private DatePickerExample datePicker = new DatePickerExample();
    private JButton confirmButton = new JButton("Potwierdź");
    private JButton cancelButton = new JButton("Anuluj");




    public AddCarDialog()
    {
        setTitle("Dodaj samochód");

        setVisible(true);
        setSize(new Dimension(500,500));
        setLocationRelativeTo(null);
        setResizable(false);

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{200, 200};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        setLayout(gridBagLayout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 10, 5, 10);
        add(brandLabel, gbc);

        gbc.gridx = 1;
        add(brandField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(modelLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(modelField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(idLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(yearLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(yearField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(statusLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        add(statusField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(colorLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        add(colorField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(seatsLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        add(seatsField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        add(horsePowerLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        add(horsePowerField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        add(mileageLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        add(mileageField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        add(dateOfServiceLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        add(datePicker, gbc);
//        add(dateOfServiceField, gbc);

        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 11;
        add(confirmButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 11;
        add(cancelButton, gbc);

//        gbc.gridx = 0;
//        gbc.gridy = 11;



        confirmButton.addActionListener(e -> {
            dispose();
        });
        cancelButton.addActionListener(e -> {
            dispose();
        });


    }

}
