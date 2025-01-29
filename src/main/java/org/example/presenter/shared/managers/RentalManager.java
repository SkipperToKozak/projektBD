package org.example.presenter.shared.managers;

import org.example.dao.*;
import org.example.model.Car;
import org.example.model.Rental;

import java.util.List;

public class RentalManager {

    RentalDAO rentalDAO;
    UserDAO userDAO;
    CarDAO carDAO;


    public RentalManager() {
        rentalDAO = new RentalDAOImpl();
        userDAO = new UserDAOImpl();
        carDAO = new CarDAOImpl();
    }

    public boolean returnCar(String carId, String clientLogin) {
        var car = carDAO.getCarById(carId);
        var user = userDAO.getUserByLogin(clientLogin);
        try {
            rentalDAO.returnCar(car, user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public List<Rental> getClientRentals(String clientLogin) {
        var client = userDAO.getUserByLogin(clientLogin);
        return rentalDAO.getClientRentals(client);

    }

    public boolean rentCar(Car car, String userLogin) {
        var user = userDAO.getUserByLogin(userLogin);
        return rentalDAO.rentCar(car, user);
    }
}
