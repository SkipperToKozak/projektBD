package org.example.model.managers;

import org.example.dao.CarDAO;
import org.example.model.Car;

import java.sql.SQLException;

public class CarManager {
    private final CarDAO carDAO;

    public CarManager() {
        carDAO = new CarDAOImpl();
    }

    public boolean addCar(String carID, String model, int year) {
        var car = new Car(carID, model, year);
        try {
            carDAO.addCar(car);
            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public Car getCarByID(String id) {
        try {
            return carDAO.getCarById(id);
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateCar(String id, String status) {
        var car = getCarByID(id);
        car.setStatus(status);
        try {
            carDAO.updateCar(car);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCar(String id) {
        var car = getCarByID(id);
        try {
            carDAO.deleteCar(car);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean blockCar(String id) {
        var car = getCarByID(id);
        try {
            carDAO.blockCar(car);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean showCars() {
        try {
            carDAO.showCars();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
