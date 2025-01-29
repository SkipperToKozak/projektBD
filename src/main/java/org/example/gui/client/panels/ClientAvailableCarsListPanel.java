package org.example.gui.client.panels;

import org.example.gui.client.panels.listElements.carPanel.AvailableCarPanel;
import org.example.gui.shared.panels.listElements.CarPanel;
import org.example.gui.client.panels.listElements.carPanel.RentedCarPanel;
import org.example.gui.client.panels.listElements.carPanel.ReservedCarPanel;
import org.example.gui.shared.panels.ScrollCenterPanel;

public class ClientAvailableCarsListPanel extends ScrollCenterPanel {
    public ClientAvailableCarsListPanel() {
        super();
        addCarPanel(new AvailableCarPanel("Renault", "Clio", "2011"));
//        listPanel.add(new CarPanel("KLIENT", "A4", "2010"));
//        listPanel.add(new CarPanel("KLIENT", "X5", "2015"));
//        listPanel.add(new RentedCarPanel("Fiat", "Punto", "2013"));
//        listPanel.add(new AvailableCarPanel("Renault", "Clio", "2011"));
//        listPanel.add(new ReservedCarPanel("Peugeot", "308", "2010"));
    }
    public void addCarPanel(AvailableCarPanel carPanel) {
        listPanel.add(carPanel);
        listPanel.add(new AvailableCarPanel("Admin", "Clio", "2011"));
        revalidate();
        repaint();
        System.out.println("Dodano samochód do listy");
    }
}
