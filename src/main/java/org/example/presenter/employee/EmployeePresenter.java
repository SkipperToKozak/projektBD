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
    private AddCarDialog addCarDialog = new AddCarDialog();
    private final CarManager carManager = new CarManager();
    private final ReservationManager reservationManager = new ReservationManager();
    private final UserManager userManager = new UserManager();

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
        this.addCarDialog.setConfirmAddCarButtonListener(e -> onConfirmAddButton());
    }

    private void onCarsButtonClicked() {
        var carsListPanel = view.getCarsListPanel();
        var carList = carManager.getCars();
        for (Car car : carList) {
            carsListPanel.addCarPanel(new EmployeeCarPanel(car.getBrand(), car.getModel(), String.valueOf(car.getProductionYear()), car.getStatus()));
        }
        view.showAvailableCarsPanel();
    }

    private void onClientsButtonClicked() {
        var clientListPanel = view.getAllClientsListPanel();
        var clientsList = userManager.getClients();
        for (User user : clientsList) {
            clientListPanel.addClientsPanel(new ClientInfoPanel(user.getFirstName(), user.getLastName(), user.getPesel()));
        }
        view.showAllClientsPanel();
    }

    private void onAddCarButtonClicked() {
        addCarDialog = view.getAddCarDialog();
        addCarDialog.setVisible(true);
    }

    private void onConfirmAddButton() {
        String carId = String.valueOf(addCarDialog.getIdField());
        String brand = String.valueOf(addCarDialog.getBrandField());
        String model = String.valueOf(addCarDialog.getModelField());
        int productionYear = Integer.parseInt(String.valueOf(addCarDialog.getYearField()));
        String status = String.valueOf(addCarDialog.getStatusField());
        String color = String.valueOf(addCarDialog.getColorField());
        int seatAmount = Integer.parseInt(String.valueOf(addCarDialog.getSeatsField()));
        int horsePower = Integer.parseInt(String.valueOf(addCarDialog.getHorsePowerField()));
        int mileage = Integer.parseInt(String.valueOf(addCarDialog.getMileageField()));
        Date date = Date.valueOf(String.valueOf(addCarDialog.getDatePicker()));

        if (carManager.addCar(carId, brand, model, productionYear, color, seatAmount, horsePower, mileage, status, date)) {
            System.out.println("WTF");
        } else {
            System.out.println("Not this time");
        }


    }

}
