package org.example.model.managers;

import org.example.dao.CarDAO;
import org.example.model.Car;

import java.sql.SQLException;
import java.time.LocalDate;

public class CarManager {
    private final CarDAO carDAO;

    public CarManager() {
        carDAO = new CarDAOImpl();
    }

    public boolean addCar(String carID, String brand, String model, int productionYear, String color, int seatAmount, int horsePower, int mileage, LocalDate lastCarInspection) {
        var car = new Car(carID, brand, model, productionYear, color, seatAmount, horsePower, mileage, lastCarInspection);
        try {
            carDAO.addCar(car);
            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    private String id;
    private String brand;
    private String model;
    private int productionYear;
    private String color;
    private int seatAmount;
    private int horsePower;
    private int mileage;
    private boolean available;
    private String status;
    private LocalDate lastCarInspection;

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
