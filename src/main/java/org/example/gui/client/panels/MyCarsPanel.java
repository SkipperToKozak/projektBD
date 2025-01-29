package org.example.gui.client.panels;

import org.example.gui.client.panels.listElements.carPanel.HistoryCarPanel;
import org.example.gui.client.panels.listElements.carPanel.RentedCarPanel;
import org.example.gui.client.panels.listElements.carPanel.ReservedCarPanel;
import org.example.gui.shared.panels.ScrollCenterPanel;

import java.awt.event.ActionListener;

public class MyCarsPanel extends ScrollCenterPanel {
    public MyCarsPanel() {
        super();
//        listPanel.add(new HistoryCarPanel("Volkswagen", "Passat", "2016", "2020-01-01", "2020-01-02"));
//        listPanel.add(new HistoryCarPanel("Skoda", "Octavia", "2014", "2020-01-01", "2020-01-02"));
    }

    public void addCarPanel(HistoryCarPanel carPanel) {
        listPanel.add(carPanel);
        System.out.println("Dodano samochód do listy");
    }

    public void addCarPanel(ReservedCarPanel reservedCarPanel) {
        listPanel.add(reservedCarPanel);
        listPanel.revalidate();
        listPanel.repaint();
        System.out.println("Dodano samchód do listy");
    }

    public void addCarPanel(RentedCarPanel rentedCarPanel) {
        listPanel.add(rentedCarPanel);
        listPanel.revalidate();
        listPanel.repaint();
        System.out.println("Dodano samchód do listy");
    }
}
