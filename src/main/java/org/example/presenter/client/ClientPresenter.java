package org.example.presenter.client;

import org.example.gui.client.dialogs.RentConfirmationDialog;
import org.example.gui.client.dialogs.ReservationConfirmationDialog;
import org.example.gui.client.panels.ClientAccountPanel;
import org.example.gui.client.panels.ClientAvailableCarsListPanel;
import org.example.gui.client.panels.ClientMainPanel;
import org.example.gui.client.panels.MyCarsPanel;
import org.example.gui.client.panels.listElements.carPanel.AvailableCarPanel;
import org.example.gui.client.panels.listElements.carPanel.HistoryCarPanel;
import org.example.presenter.shared.managers.CarManager;
import org.example.presenter.shared.managers.ReservationManager;
import org.example.presenter.shared.managers.UserManager;

import javax.swing.*;

public class ClientPresenter {
    private final String username = "jan_kowalski";
    private ClientMainPanel view;
    private final CarManager carManager = new CarManager();
    private final ReservationManager reservationManager = new ReservationManager();
    private final UserManager userManager = new UserManager();
    private ClientAvailableCarsListPanel clientAvailableCarsListPanel;
    private MyCarsPanel myCarsPanel;
    private ClientAccountPanel myAccountPanel;

    public ClientPresenter() {
        SwingUtilities.invokeLater(() -> {
            view = new ClientMainPanel(username);
            initListeners();
        });


    }

    private void initListeners() {

        this.view.setAvailableCarsButtonListener(e -> onAvailableCarsButtonClicked());
        this.view.setMyCarsButtonListener(e -> onMyCarsButtonClicked());
        this.view.setMyAccountButtonListener(e -> onMyAccountButtonClicked());

    }

    private void onAvailableCarsButtonClicked() {
        // Pobranie panelu z widoku (jeśli istnieje)
        clientAvailableCarsListPanel = view.getClientAvailableCarsListPanel();
        clientAvailableCarsListPanel.getListPanel().removeAll();


        // Pobranie dostępnych samochodów
        var carList = carManager.getAvailableCars();

        // Dodanie samochodów do panelu
        for (var car : carList) {
            AvailableCarPanel availableCarPanel = new AvailableCarPanel(car.getBrand(), car.getModel(), String.valueOf(car.getProductionYear()));
            availableCarPanel.setRentButtonListener(e -> onRentButtonClicked());
            availableCarPanel.setReserveButtonListener(e -> onRentCarButtonClicked());
            clientAvailableCarsListPanel.addCarPanel(availableCarPanel);
            System.out.println("Dodano: " + car.getBrand() + " " + car.getId());
        }

        // Wymuszenie odświeżenia widoku
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
            myAccountPanel.getNameLabel().setText("Imię: " + user.getFirstName());
            myAccountPanel.getSurnameLabel().setText("Nazwisko: " + user.getLastName());
            myAccountPanel.getPeselLabel().setText("PESEL: " + user.getPesel());


    }
    private void onRentButtonClicked() {
            JDialog dialog = new ReservationConfirmationDialog();
            dialog.setVisible(true);
    }
    private void onRentCarButtonClicked() {

        JDialog dialog = new RentConfirmationDialog();
        dialog.setVisible(true);
    }

}
