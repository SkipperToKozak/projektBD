package org.example.presenter.employee;

import org.example.gui.client.panels.ClientMainPanel;
import org.example.gui.client.panels.listElements.carPanel.AvailableCarPanel;
import org.example.gui.employee.dialogs.AddCarDialog;
import org.example.gui.employee.panels.AllClientsListPanel;
import org.example.gui.employee.panels.EmployeeCarsListPanel;
import org.example.gui.employee.panels.EmployeeMainPanel;
import org.example.gui.employee.panels.listElements.ClientInfoPanel;
import org.example.gui.employee.panels.listElements.EmployeeCarPanel;
import org.example.model.Car;
import org.example.model.User;
import org.example.presenter.shared.managers.CarManager;
import org.example.presenter.shared.managers.ReservationManager;
import org.example.presenter.shared.managers.UserManager;

import javax.swing.*;
import java.sql.Date;

public class EmployeePresenter {
    private EmployeeMainPanel view;
    private final CarManager carManager = new CarManager();
    private final ReservationManager reservationManager = new ReservationManager();
    private final UserManager userManager = new UserManager();
    private EmployeeCarsListPanel carsListPanel;
    private AllClientsListPanel clientListPanel;

    public EmployeePresenter() {
        SwingUtilities.invokeLater(() -> {
            view = new EmployeeMainPanel("Test");
            initListeners();
        });

    }

    private void initListeners() {
        this.view.setCarsButtonListener(e -> onCarsButtonClicked());
        this.view.setClientsButtonListener(e -> onClientsButtonClicked());
        this.view.setAddCarButtonListener(e -> onAddCarButtonClicked());
    }

    private void onCarsButtonClicked() {
        carsListPanel = view.getCarsListPanel();
        carsListPanel.getListPanel().removeAll();

        var carList = carManager.getCars();
        for (Car car : carList) {
            carsListPanel.addCarPanel(new EmployeeCarPanel(car.getBrand(), car.getModel(), String.valueOf(car.getProductionYear()), car.getStatus()));
        }
        view.showAvailableCarsPanel();
    }

    private void onClientsButtonClicked() {
        clientListPanel = view.getAllClientsListPanel();
        clientListPanel.getListPanel().removeAll();

        var clientsList = userManager.getClients();
        for (User user : clientsList) {
            clientListPanel.addClientsPanel(new ClientInfoPanel(user.getFirstName(), user.getLastName(), user.getPesel()));
        }
        view.showAllClientsPanel();
    }

    private void onAddCarButtonClicked() {
        AddCarDialog addCarDialog = new AddCarDialog();
        addCarDialog.setConfirmAddCarButtonListener(e -> onConfirmAddButton(addCarDialog));
        addCarDialog.setVisible(true);
    }

    private void onConfirmAddButton(AddCarDialog addCarDialog) {
        System.out.println("Przycisk został kliknięty!"); // Sprawdzenie działania

        String carId = addCarDialog.getIdField().getText();
        String brand = addCarDialog.getBrandField().getText();
        String model = addCarDialog.getModelField().getText();
        int productionYear = Integer.parseInt(addCarDialog.getYearField().getText());
        String status = (String) addCarDialog.getStatusField().getSelectedItem();
        String color = addCarDialog.getColorField().getText();
        int seatAmount = Integer.parseInt(addCarDialog.getSeatsField().getText());
        int horsePower = Integer.parseInt(addCarDialog.getHorsePowerField().getText());
        int mileage = Integer.parseInt(addCarDialog.getMileageField().getText());
//        java.sql.Date date = java.sql.Date.valueOf(addCarDialog.getDatePicker().get);
        Date date = null;

        if (carManager.addCar(carId, brand, model, productionYear, color, seatAmount, horsePower, mileage, status, date)) {
            System.out.println("Dodano nowy samochód");
            onCarsButtonClicked(); // Odświeżenie listy samochodów po dodaniu nowego auta
            addCarDialog.dispose();

        } else {
            System.out.println("Nie udało się dodać nowego samochodu");
        }


    }

}
