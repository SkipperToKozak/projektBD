package org.example.presenter.client;

import org.example.gui.client.panels.ClientAvailableCarsListPanel;
import org.example.gui.client.panels.ClientMainPanel;
import org.example.gui.client.panels.listElements.carPanel.AvailableCarPanel;
import org.example.model.User;
import org.example.presenter.shared.managers.CarManager;
import org.example.presenter.shared.managers.ReservationManager;
import org.example.presenter.shared.managers.UserManager;

public class ClientPresenter {
    private final String username = "jan_kowalski";
    private final ClientMainPanel view = new ClientMainPanel("username");
    private final CarManager carManager = new CarManager();
    private final ReservationManager reservationManager = new ReservationManager();
    private final UserManager userManager = new UserManager();
    private ClientAvailableCarsListPanel clientAvailableCarsListPanel = view.getClientAvailableCarsListPanel();

    public ClientPresenter() {
        this.view.setAvailableCarsButtonListener(e -> onAvailableCarsButtonClicked());
        this.view.setMyCarsButtonListener(e -> onMyCarsButtonClicked());

    }
    private void onAvailableCarsButtonClicked() {
        var carList  = carManager.getAvailableCars();
//        clientAvailableCarsListPanel.addCarPanel(new AvailableCarPanel("Renault", "Clio", "2011"));
        for (var car : carList) {

            clientAvailableCarsListPanel.addCarPanel(new AvailableCarPanel(car.getBrand(), car.getModel(), String.valueOf(car.getProductionYear())));
            System.out.println(car.getBrand()+car.getId());
        }
        view.showAvailableCarsPanel();
    }
    private void onMyCarsButtonClicked() {
        var carList  = carManager.getCars();
        for (var car : carList) {
//            if(username.equals(car.()))
            clientAvailableCarsListPanel.addCarPanel(new AvailableCarPanel(car.getBrand(), car.getModel(), String.valueOf(car.getProductionYear())));
            System.out.println(car.getBrand()+car.getId());
        }
        view.showMyCarsPanel();
    }

}
