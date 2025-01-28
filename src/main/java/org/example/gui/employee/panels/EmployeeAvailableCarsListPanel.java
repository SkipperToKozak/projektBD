package org.example.gui.employee.panels;

import org.example.gui.client.panels.listElements.carPanel.AvailableCarPanel;
import org.example.gui.shared.panels.listElements.CarPanel;
import org.example.gui.client.panels.listElements.carPanel.RentedCarPanel;
import org.example.gui.client.panels.listElements.carPanel.ReservedCarPanel;
import org.example.gui.shared.panels.ScrollCenterPanel;

public class EmployeeAvailableCarsListPanel extends ScrollCenterPanel {
    public EmployeeAvailableCarsListPanel() {
        super();
        listPanel.add(new CarPanel("ADMIN", "A4", "2010"));
        listPanel.add(new CarPanel("ADMIN", "X5", "2015"));
        listPanel.add(new CarPanel("Mercedes", "S500", "2018"));
        listPanel.add(new CarPanel("Toyota", "Corolla", "2012"));
        listPanel.add(new CarPanel("Ford", "Focus", "2019"));
        listPanel.add(new CarPanel("Opel", "Astra", "2017"));
        listPanel.add(new CarPanel("Volkswagen", "Passat", "2016"));
        listPanel.add(new CarPanel("Skoda", "Octavia", "2014"));
        listPanel.add(new CarPanel("Fiat", "Punto", "2013"));
        listPanel.add(new CarPanel("Renault", "Clio", "2011"));
        listPanel.add(new CarPanel("Peugeot", "308", "2010"));
        listPanel.add(new CarPanel("Ford", "Focus", "2019"));
        listPanel.add(new CarPanel("Opel", "Astra", "2017"));
        listPanel.add(new CarPanel("Volkswagen", "Passat", "2016"));
        listPanel.add(new CarPanel("Skoda", "Octavia", "2014"));
        listPanel.add(new RentedCarPanel("Fiat", "Punto", "2013"));
        listPanel.add(new AvailableCarPanel("Renault", "Clio", "2011"));
        listPanel.add(new ReservedCarPanel("Peugeot", "308", "2010"));

    }

}
