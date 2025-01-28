package org.example.gui.shared.dialogs;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class DatePickerExample extends JPanel {

    private static JDatePickerImpl datePicker;
    private JFormattedTextField textField;

    public DatePickerExample() {
        setSize(400, 200);
        setLayout(new FlowLayout());

        // Utwórz model dla JDatePicker
        UtilDateModel model = new UtilDateModel();
        Properties properties = new Properties();
        properties.put("text.today", "Today");
        properties.put("text.month", "Month");
        properties.put("text.year", "Year");

        JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        textField = datePicker.getJFormattedTextField();
        textField.setPreferredSize(new Dimension(150, 20));

        // Dodaj JDatePicker do okna
        add(datePicker);

        // Dodaj przycisk do pobrania wybranej daty
//        JButton getDateButton = new JButton("Get Selected Date");
//        getDateButton.addActionListener(e -> {
//            Date selectedDate = (Date) datePicker.getModel().getValue();
//            if (selectedDate != null) {
//                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                System.out.println("Selected Date: " + dateFormat.format(selectedDate));
//                JOptionPane.showMessageDialog(this, "Selected Date: " + dateFormat.format(selectedDate));
//            } else {
//                JOptionPane.showMessageDialog(this, "No Date Selected!");
//            }
//        });
//        add(getDateButton);
    }

    public JFormattedTextField getTextField() {
        return textField;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DatePickerExample example = new DatePickerExample();
            example.setVisible(true);
        });
    }

    // Formatter for the JDatePicker
    private static class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {
        private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        DateLabelFormatter() {
//            dateFormat.setLenient(false);;
        }

        @Override
        public Object stringToValue(String text) throws java.text.ParseException {
            return dateFormat.parse(text);
        }

        @Override
        public String valueToString(Object value) {
            if (value != null) {

                //ten kod jest bardzo niedobry ale działa
                Date selectedDate = (Date) datePicker.getModel().getValue();
                System.out.println("aaa");
                System.out.println("Selected Date: " + dateFormat.format(selectedDate));

                return dateFormat.format(selectedDate);
            }
            return "";
        }
    }
}
