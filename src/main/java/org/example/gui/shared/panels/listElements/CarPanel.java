package org.example.gui.shared.panels.listElements;

import org.example.model.Car;

import javax.swing.*;
import java.awt.*;

public class CarPanel extends JPanel {
    protected JLabel carBrandLabel;
    protected JLabel carModelLabel;
    protected JLabel carYearLabel;
    protected JLabel carIdLabel;
    protected JLabel carStatusLabel;
    protected JLabel carColorLabel;
    protected JLabel carSeatsLabel;
    protected JLabel carPowerLabel;
    protected JLabel carMilageLabel;
//    protected JLabel carDateOfServiceLabel;

    protected JPanel buttonPanel;
    protected String carBrand;
    protected String carModel;
    protected String carYear;
    protected String carId;
    protected String carStatus;
    protected String carColor;
    protected String carSeats;
    protected String carPower;
    protected String carMilage;
//    protected String carDateOfService;


    public CarPanel(Car car) {
        this.carBrand = car.getBrand();
        this.carModel = car.getModel();
        this.carYear = String.valueOf(car.getProductionYear());;
        this.carId = car.getId();
        this.carStatus = car.getStatus();
        this.carColor = car.getColor();
        this.carSeats = String.valueOf(car.getSeatAmount());
        this.carPower = String.valueOf(car.getHorsePower());
        this.carMilage = String.valueOf(car.getMileage());
//        this.carDateOfService = car.getLastCarInspection().toString();
        carBrandLabel = new JLabel("Marka: " + carBrand);
        carModelLabel = new JLabel("Model: " + carModel);
        carYearLabel = new JLabel("Rok produkcji: " + carYear);
        carIdLabel = new JLabel("ID: " + carId);
        carStatusLabel = new JLabel("Status: " + carStatus);
        carColorLabel = new JLabel("Kolor: " + carColor);
        carSeatsLabel = new JLabel("Ilość miejsc: " + carSeats);
        carPowerLabel = new JLabel("Moc: " + carPower);
        carMilageLabel = new JLabel("Przebieg: " + carMilage);
//        carDateOfServiceLabel = new JLabel("Data ostatniego przeglądu: " + carDateOfService);

        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createRaisedBevelBorder());
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createEmptyBorder()));
//        setBackground(Color.CYAN);
        setMaximumSize(new Dimension(750, 90));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 10, 5, 10);


        gbc.gridx = 0;
        gbc.gridy = 0;
        add(carBrandLabel, gbc);

        gbc.gridx = 1;
        add(carModelLabel, gbc);

        gbc.gridx = 2;
        add(carYearLabel, gbc);

        gbc.gridx = 3;
        add(carIdLabel, gbc);

        gbc.gridx = 4;
        add(carStatusLabel, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        add(carColorLabel, gbc);

        gbc.gridx = 1;
        add(carSeatsLabel, gbc);

        gbc.gridx = 2;
        add(carPowerLabel, gbc);

        gbc.gridx = 3;
        add(carMilageLabel, gbc);

//        gbc.gridx = 4;
//        add(new JLabel("Data ostatniego przeglądu: " + carDateOfService), gbc);



        gbc.gridwidth = 5;
        gbc.gridx = 0;
        gbc.gridy = 2;
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        add(buttonPanel, gbc);

        // Ustaw preferowany rozmiar (opcjonalnie)
//        setPreferredSize(new Dimension(300, 60));
    }
    protected void setLabelsForeground(Color color) {
        carBrandLabel.setForeground(color);
        carModelLabel.setForeground(color);
        carYearLabel.setForeground(color);
        carIdLabel.setForeground(color);
        carStatusLabel.setForeground(color);
        carColorLabel.setForeground(color);
        carSeatsLabel.setForeground(color);
        carPowerLabel.setForeground(color);
        carMilageLabel.setForeground(color);
//        carDateOfServiceLabel.setForeground(color);
    }
}
