package org.example.gui.employee.panels;

import org.example.gui.client.panels.listElements.carPanel.AvailableCarPanel;
import org.example.gui.employee.panels.listElements.ClientInfoPanel;
import org.example.gui.shared.panels.ScrollCenterPanel;

public class AllClientsListPanel extends ScrollCenterPanel {
    public AllClientsListPanel() {
        super();
//        listPanel.add(new ClientInfoPanel("Jan", "Kowalski", "123456789"));
//        listPanel.add(new ClientInfoPanel("Adam", "Nowak", "987654321"));
//        listPanel.add(new ClientInfoPanel("Anna", "Kowalczyk", "123123123"));
//        listPanel.add(new ClientInfoPanel("Krzysztof", "Kowal", "456456456"));
//        listPanel.add(new ClientInfoPanel("Katarzyna", "Nowak", "789789789"));
//        listPanel.add(new ClientInfoPanel("Piotr", "Kowalski", "321321321"));
//        listPanel.add(new ClientInfoPanel("Karolina", "Nowak", "654654654"));
//        listPanel.add(new ClientInfoPanel("Marek", "Kowalczyk", "987987987"));
//        listPanel.add(new ClientInfoPanel("Wojciech", "Kowal", "654654654"));
//        listPanel.add(new ClientInfoPanel("Kamila", "Nowak", "321321321"));
//        listPanel.add(new ClientInfoPanel("Krzysztof", "Kowalski", "987987987"));
//        listPanel.add(new ClientInfoPanel("Anna", "Nowak", "654654654"));
//        listPanel.add(new ClientInfoPanel("Piotr", "Kowalczyk", "321321321"));
//        listPanel.add(new ClientInfoPanel("Karolina", "Kowal", "987987987"));
//        listPanel.add(new ClientInfoPanel("Marek", "Kowalski", "654654654"));
//        listPanel.add(new ClientInfoPanel("Wojciech", "Nowak", "321321321"));
//        listPanel.add(new ClientInfoPanel("Kamila", "Kowalski", "987987987"));
    }

    public void addClientsPanel(ClientInfoPanel clientInfoPanel) {
        listPanel.add(clientInfoPanel);
    }
}
