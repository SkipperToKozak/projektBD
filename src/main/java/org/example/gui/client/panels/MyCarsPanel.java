package org.example.gui.client.panels;

import org.example.gui.client.panels.listElements.carPanel.HistoryCarPanel;
import org.example.gui.shared.panels.ScrollCenterPanel;

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
}
