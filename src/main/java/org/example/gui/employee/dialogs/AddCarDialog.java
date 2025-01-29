package org.example.gui.employee.dialogs;

//import org.example.gui.shared.dialogs.DatePicker;
import org.example.gui.shared.dialogs.DatePickerExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddCarDialog extends JDialog
{

    protected JLabel brandLabel = new JLabel("Marka");
    protected JTextField brandField = new JTextField();
    protected JLabel modelLabel = new JLabel("Model");
    protected JTextField modelField = new JTextField();
    protected JLabel idLabel = new JLabel("Numer rejestracyjny");
    protected JTextField idField = new JTextField();
    protected JLabel yearLabel = new JLabel("Rok produkcji");
    protected JTextField yearField = new JTextField();
    protected JLabel statusLabel = new JLabel("Status");
    protected JComboBox statusField = new JComboBox();
    protected JLabel colorLabel = new JLabel("Kolor");
    protected JTextField colorField = new JTextField();
    protected JLabel seatsLabel = new JLabel("Ilość miejsc");
    protected JTextField seatsField = new JTextField();
    protected JLabel horsePowerLabel = new JLabel("Moc");
    protected JTextField horsePowerField = new JTextField();
    protected JLabel mileageLabel = new JLabel("Przebieg");
    protected JTextField mileageField = new JTextField();
    protected JLabel dateOfServiceLabel = new JLabel("Data ostatniego przegladu");
//    protected JTextField dateOfServiceField = new JTextField();
    protected DatePickerExample datePicker = new DatePickerExample();
    protected JButton confirmButton = new JButton("Dodaj");
    protected JButton cancelButton = new JButton("Anuluj");





    public AddCarDialog()
    {
        setTitle("Dodaj samochód");


        setSize(new Dimension(500,500));
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);


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

        statusField.addItem("dostepny");
        statusField.addItem("usuniety");
        statusField.addItem("zablokowany");

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



//        confirmButton.addActionListener(e -> {
//            dispose();
//        });
        cancelButton.addActionListener(e -> {
            dispose();
        });


    }

    public void setConfirmAddCarButtonListener(ActionListener listener) {
        confirmButton.addActionListener(listener);
        dispose();
    }

    public JTextField getBrandField() {
        return brandField;
    }

    public JTextField getModelField() {
        return modelField;
    }

    public JTextField getIdField() {
        return idField;
    }

    public JTextField getYearField() {
        return yearField;
    }

    public JComboBox getStatusField() {
        return statusField;
    }

    public JTextField getColorField() {
        return colorField;
    }

    public JTextField getSeatsField() {
        return seatsField;
    }

    public JTextField getMileageField() {
        return mileageField;
    }

    public DatePickerExample getDatePicker() {
        return datePicker;
    }

    public JTextField getHorsePowerField() {
        return horsePowerField;
    }
}
