package org.example.presenter.employee;

import org.example.gui.client.panels.listElements.carPanel.AvailableCarPanel;
import org.example.gui.employee.panels.AllClientsListPanel;
import org.example.gui.employee.panels.EmployeeCarsListPanel;
import org.example.gui.employee.panels.EmployeeMainPanel;
import org.example.gui.employee.panels.listElements.ClientInfoPanel;
import org.example.model.Car;
import org.example.model.User;
import org.example.presenter.shared.managers.CarManager;
import org.example.presenter.shared.managers.ReservationManager;
import org.example.presenter.shared.managers.UserManager;

public class EmployeePresenter {
    private final EmployeeMainPanel view = new EmployeeMainPanel("Test");
    private final CarManager carManager = new CarManager();
    private final ReservationManager reservationManager = new ReservationManager();
    private final UserManager userManager = new UserManager();

    public EmployeePresenter() {
        this.view.setCarsButtonListener(e -> onCarsButtonClicked());
        this.view.setClientsButtonListener(e -> onClientsButtonClicked());

    }

    private void onCarsButtonClicked() {
        var carsListPanel = view.getCarsListPanel();
        var carList = carManager.getCars();
        for (Car car : carList) {
            carsListPanel.addCarPanel(new AvailableCarPanel(car.getBrand(), car.getModel(), String.valueOf(car.getProductionYear())));
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

    }

}
