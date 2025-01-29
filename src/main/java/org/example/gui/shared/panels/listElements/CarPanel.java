package org.example.gui.shared.panels.listElements;

import javax.swing.*;
import java.awt.*;

public class CarPanel extends JPanel {
    protected JLabel carBrandLabel;
    protected JLabel carModelLabel;
    protected JLabel carYearLabel;
    protected JPanel buttonPanel;
    protected String carBrand;
    protected String carModel;
    protected String carYear;


    public CarPanel(String carBrand, String carModel, String carYear) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carYear = carYear;
        carBrandLabel = new JLabel("Marka: " + carBrand);
        carModelLabel = new JLabel("Model: " + carModel);
        carYearLabel = new JLabel("Rok produkcji: " + carYear);

        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createRaisedBevelBorder());
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createEmptyBorder()));
//        setBackground(Color.CYAN);
        setMaximumSize(new Dimension(550, 90));
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

        gbc.gridwidth = 3;
        gbc.gridx = 0;
        gbc.gridy = 3;
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        add(buttonPanel, gbc);

        // Ustaw preferowany rozmiar (opcjonalnie)
        setPreferredSize(new Dimension(300, 60));
    }
    protected void setLabelsForeground(Color color) {
        carBrandLabel.setForeground(color);
        carModelLabel.setForeground(color);
        carYearLabel.setForeground(color);
    }
}
