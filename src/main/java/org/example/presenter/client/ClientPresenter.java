package org.example.presenter.client;

import org.example.gui.client.dialogs.RentConfirmationDialog;
import org.example.gui.client.dialogs.ReservationConfirmationDialog;
import org.example.gui.client.panels.ClientAccountPanel;
import org.example.gui.client.panels.ClientAvailableCarsListPanel;
import org.example.gui.client.panels.ClientMainPanel;
import org.example.gui.client.panels.MyCarsPanel;
import org.example.gui.client.panels.listElements.carPanel.AvailableCarPanel;
import org.example.gui.client.panels.listElements.carPanel.HistoryCarPanel;
import org.example.gui.client.panels.listElements.carPanel.RentedCarPanel;
import org.example.gui.client.panels.listElements.carPanel.ReservedCarPanel;
import org.example.model.Car;
import org.example.model.Reservation;
import org.example.model.User;
import org.example.presenter.shared.managers.CarManager;
import org.example.presenter.shared.managers.RentalManager;
import org.example.presenter.shared.managers.ReservationManager;
import org.example.presenter.shared.managers.UserManager;

import javax.swing.*;
import java.util.Objects;

public class ClientPresenter {
    private User user;
    private String username;
    private ClientMainPanel view;
    private final CarManager carManager = new CarManager();
    private final ReservationManager reservationManager = new ReservationManager();
    private final UserManager userManager = new UserManager();
    private final RentalManager rentalManager = new RentalManager();
    private ClientAvailableCarsListPanel clientAvailableCarsListPanel;
    private MyCarsPanel myCarsPanel;
    private ClientAccountPanel myAccountPanel;

    public ClientPresenter(User user) {
        this.user = user;
        this.username = user.getLogin();
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
            AvailableCarPanel availableCarPanel = new AvailableCarPanel(car);
            availableCarPanel.setRentButtonListener(e -> onRentButtonClicked(car, availableCarPanel));
            availableCarPanel.setReserveButtonListener(e -> onReserveButtonClicked(car, availableCarPanel));
            clientAvailableCarsListPanel.addCarPanel(availableCarPanel);
            System.out.println("Dodano: " + car.getBrand() + " " + car.getId());
        }

        // Wymuszenie odświeżenia widoku
        view.showAvailableCarsPanel();
    }

    private void onMyCarsButtonClicked() {
        myCarsPanel = view.getMyCarsPanel();
        myCarsPanel.getListPanel().removeAll();
        var reservationList  = reservationManager.getClientReservations(username);
        var rentList  = rentalManager.getClientRentals(username);

        for (var reservation : reservationList) {
            var car = carManager.getCarByID(reservation.getCarId());
            System.out.println("Wyswietlono na liscie: " + car.getId());
            if (Objects.equals(reservation.getStatus(), "zakonczona")) {
                myCarsPanel.addCarPanel(new HistoryCarPanel(car, reservation));
            } else {
                ReservedCarPanel reservedCarPanel = new ReservedCarPanel(car, reservation);
                myCarsPanel.addCarPanel(reservedCarPanel);
                reservedCarPanel.setReserveButtonListener(e -> onRentButtonClicked(car, reservedCarPanel));
            }
        }
        for (var rent : rentList) {
            var car = carManager.getCarByID(rent.getCarId());
            System.out.println("Wyswietlono na liscie: " + car.getId());
            if (Objects.equals(rent.getStatus(), "zakonczone")) {
                myCarsPanel.addCarPanel(new HistoryCarPanel(car, rent));
            } else {
                RentedCarPanel rentedCarPanel = new RentedCarPanel(car, rent);
                myCarsPanel.addCarPanel(rentedCarPanel);
            }
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
    private void onRentButtonClicked(Car car, AvailableCarPanel availableCarPanel) {
        RentConfirmationDialog dialog = new RentConfirmationDialog(car);
        dialog.setConfirmRentButtonListener(e -> onConfirmRentButtonClicked(car, availableCarPanel));
        dialog.setCancelRentButtonListener(e -> dialog.dispose());
        dialog.setVisible(true);
    }

    private void onRentButtonClicked(Car car, ReservedCarPanel reservedCarPanel) {
        RentConfirmationDialog dialog = new RentConfirmationDialog(car);
        dialog.setConfirmRentButtonListener(e -> onConfirmRentButtonClicked(car, reservedCarPanel));
        dialog.setCancelRentButtonListener(e -> dialog.dispose());
        dialog.setVisible(true);
    }

    private void onConfirmRentButtonClicked(Car car, AvailableCarPanel availableCarPanel) {
        //zmiana statusu samochodu na wypozyczony
        //sprawdzenie czy udalo sie wypozyyczyc
        //jesli tak to usuniecie panelu z listy
        availableCarPanel.setVisible(false);
        if (rentalManager.rentCar(car, username)) {
            System.out.println("Wypożyczono: " + car.getBrand() + " " + car.getId());
            availableCarPanel.setVisible(false);
        } else {

        }
    }

    private void onConfirmRentButtonClicked(Car car, ReservedCarPanel rentedCarPanel) {
        rentedCarPanel.setVisible(false);
        if (rentalManager.rentCar(car, username)) {
            System.out.println("Wypożyczono: " + car.getBrand() + " " + car.getId());
            rentedCarPanel.setVisible(false);
        } else {

        }
    }

    private void onReserveButtonClicked(Car car, AvailableCarPanel availableCarPanel) {
        ReservationConfirmationDialog dialog = new ReservationConfirmationDialog(car);
        dialog.setReservationConfirmButtonDialogListener(e -> onConfirmReserveButtonClicked(car, availableCarPanel));
        dialog.setReservationCancelButtonDialogListener(e -> dialog.dispose());
        dialog.setVisible(true);


    }
    private void onConfirmReserveButtonClicked(Car car, AvailableCarPanel availableCarPanel) {
        //zmiana statusu samochodu na zarezerwowany
        //sprawdzenie czy udalo sie zarezerwowac
        //jesli tak to usuniecie panelu z listy
        availableCarPanel.setVisible(false);
        if (reservationManager.reserveCar(car, username)) {
            System.out.println("Zarezerwowano: " + car.getBrand() + " " + car.getId());

        } else {

        }
    }


}
