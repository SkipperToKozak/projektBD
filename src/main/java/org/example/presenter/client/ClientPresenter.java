package org.example.presenter.client;

import org.example.gui.client.panels.ClientAccountPanel;
import org.example.gui.client.panels.ClientAvailableCarsListPanel;
import org.example.gui.client.panels.ClientMainPanel;
import org.example.gui.client.panels.MyCarsPanel;
import org.example.gui.client.panels.listElements.carPanel.AvailableCarPanel;
import org.example.gui.client.panels.listElements.carPanel.HistoryCarPanel;
import org.example.gui.shared.panels.listElements.CarPanel;
import org.example.model.User;
import org.example.presenter.shared.managers.CarManager;
import org.example.presenter.shared.managers.ReservationManager;
import org.example.presenter.shared.managers.UserManager;

public class ClientPresenter {
    private final String username = "jan_kowalski";
    private final ClientMainPanel view = new ClientMainPanel(username);
    private final CarManager carManager = new CarManager();
    private final ReservationManager reservationManager = new ReservationManager();
    private final UserManager userManager = new UserManager();
    private ClientAvailableCarsListPanel clientAvailableCarsListPanel;
    private MyCarsPanel myCarsPanel = view.getMyCarsPanel();
    private ClientAccountPanel myAccountPanel;
    public ClientPresenter() {
        this.view.setAvailableCarsButtonListener(e -> onAvailableCarsButtonClicked());
        this.view.setMyCarsButtonListener(e -> onMyCarsButtonClicked());

    }
    private void onAvailableCarsButtonClicked() {
        clientAvailableCarsListPanel = view.getAvailableCarsListPanel();
        var carList  = carManager.getAvailableCars();

//        clientAvailableCarsListPanel.addCarPanel(new AvailableCarPanel("Renault", "Clio", "2011"));

        for (var car : carList) {

            clientAvailableCarsListPanel.addCarPanel(new AvailableCarPanel(car.getBrand(), car.getModel(), String.valueOf(car.getProductionYear())));
            System.out.println(car.getBrand()+car.getId());
        }
        view.showAvailableCarsPanel();
    }
    private void onMyCarsButtonClicked() {
        myCarsPanel = view.getMyCarsPanel();
        var reservationList  = reservationManager.getClientReservations(username);
        var rentList  = reservationManager.getClientRentals(username);

        for (var reservation : reservationList) {
//            System.out.println(reservation.getCarId());
            var car = carManager.getCarByID("ABC123");
            myCarsPanel.addCarPanel(new HistoryCarPanel(car.getBrand(), car.getModel(), String.valueOf(car.getProductionYear()), reservation.getStartDate().toString(), reservation.getEndDate().toString()));
        }
        view.showMyCarsPanel();
    }
    private void onMyAccountButtonClicked() {
         myAccountPanel = view.getClientAccountPanel();
            var user = userManager.getClients().stream().filter(u -> u.getLogin().equals(username)).findFirst().get();




    }

}
