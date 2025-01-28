package org.example.gui.employee.dialogs;

public class UpdateCarDialog extends AddCarDialog{
    public UpdateCarDialog(String brand, String model, String id,
                           String year, String status, String color,
                           String seats, String horsePower,
                           String mileage, String date ) {
        super();
        setTitle("Aktualizuj samochód");
        confirmButton.setText("Aktualizuj");

        brandField.setEnabled(false);
        brandField.setText(brand);

        modelField.setEnabled(false);
        modelField.setText(model);

        yearField.setEnabled(false);
        yearField.setText(year);

        seatsField.setEnabled(false);
        seatsField.setText(seats);

        horsePowerField.setEnabled(false);
        horsePowerField.setText(horsePower);

        mileageField.setText(mileage);
//        dateField.setText(date);

        idField.setEnabled(false);
        idField.setText(id);

        datePicker.getTextField().setText(date);

        statusField.setSelectedItem(status);

        colorField.setText(color);





    }
}
