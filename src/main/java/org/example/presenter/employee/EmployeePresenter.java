package org.example.presenter.employee;

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
    private User user;
    private final CarManager carManager = new CarManager();
    private final ReservationManager reservationManager = new ReservationManager();
    private final UserManager userManager = new UserManager();
    private EmployeeCarsListPanel carsListPanel;
    private AllClientsListPanel clientListPanel;

    public EmployeePresenter(User user) {
        this.user = user;
        SwingUtilities.invokeLater(() -> {
            view = new EmployeeMainPanel(user.getLogin());
            initListeners();
            onCarsButtonClicked();

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
            EmployeeCarPanel employeeCarPanel = new EmployeeCarPanel(car);
            employeeCarPanel.setBlockButtonListener(e -> onBlockButtonClicked(car, employeeCarPanel));
            employeeCarPanel.setUnblockButtonListener(e -> onUnblockButtonClicked(car, employeeCarPanel));
            employeeCarPanel.setDeleteButtonListener(e -> onDeleteButtonClicked(car, employeeCarPanel));
            employeeCarPanel.setUpdateButtonListener(e -> onUpdateButtonClicked(car, employeeCarPanel));
            carsListPanel.addCarPanel(employeeCarPanel);
        }
        view.showAvailableCarsPanel();
    }

    private void onUpdateButtonClicked(Car car, EmployeeCarPanel employeeCarPanel) {



    }

    private void onDeleteButtonClicked(Car car, EmployeeCarPanel employeeCarPanel) {
        String status = "usuniety";
        employeeCarPanel.setStatus(status);
        employeeCarPanel.updateStatus();
        System.out.println("Usunięto samochód: " + car.getId());
        carManager.deleteCar(car.getId());
        onCarsButtonClicked();
    }

    private void onBlockButtonClicked(Car car, EmployeeCarPanel employeeCarPanel) {
        String status = "zablokowany";
        employeeCarPanel.setStatus(status);
        employeeCarPanel.updateStatus();
        carManager.blockCar(car.getId());
        onCarsButtonClicked();
        System.out.println("Zablokowano samochód: " + car.getId());
    }

    private void onUnblockButtonClicked(Car car, EmployeeCarPanel employeeCarPanel) {
        String status = "dostepny";
        employeeCarPanel.setStatus(status);
        employeeCarPanel.updateStatus();
        carManager.unblockCar(car.getId());
        onCarsButtonClicked();
        System.out.println("Odblokowano samochód: " + car.getId());
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
        //java.sql.Date date = java.sql.Date.valueOf(addCarDialog.getDatePicker().toString());
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
