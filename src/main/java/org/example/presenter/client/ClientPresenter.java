package org.example.presenter.client;

import org.example.gui.client.panels.ClientAvailableCarsListPanel;
import org.example.gui.client.panels.ClientMainPanel;
import org.example.gui.client.panels.listElements.carPanel.AvailableCarPanel;
import org.example.gui.employee.panels.ClientCarsListPanel;
import org.example.presenter.shared.managers.CarManager;

public class ClientPresenter {
    private final ClientMainPanel view = new ClientMainPanel("Test");
    private final CarManager carManager = new CarManager();
    private ClientAvailableCarsListPanel clientAvailableCarsListPanel = view.getClientAvailableCarsListPanel();

    public ClientPresenter() {
        this.view.setAvailableCarsButtonListener(e -> onAvailableCarsButtonClicked());

    }
    private void onAvailableCarsButtonClicked() {
        var carList  = carManager.showCars();
//        clientAvailableCarsListPanel.addCarPanel(new AvailableCarPanel("Renault", "Clio", "2011"));
        for (var car : carList) {

            clientAvailableCarsListPanel.addCarPanel(new AvailableCarPanel(car.getBrand(), car.getModel(), String.valueOf(car.getProductionYear())));
            System.out.println(car.getBrand()+car.getId());
        }
        view.showAvailableCarsPanel();
    }

}
