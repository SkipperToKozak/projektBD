package org.example.presenter.shared.managers;

import org.example.dao.CarDAO;
import org.example.dao.CarDAOImpl;
import org.example.model.Car;

import java.sql.Date;
import java.util.List;

public class CarManager {
    private final CarDAO carDAO;

    public CarManager() {
        carDAO = new CarDAOImpl();
    }

    public boolean addCar(String carID, String brand, String model, int productionYear, String color, int seatAmount, int horsePower, int mileage, String status, Date lastCarInspection) {
        var car = new Car(carID, brand, model, productionYear, color, seatAmount, horsePower, mileage, status, lastCarInspection);
        return carDAO.addCar(car);
    }

    public Car getCarByID(String id) {
        return carDAO.getCarById(id);
    }

    public boolean updateCar(String id, String status) {
        var car = getCarByID(id);
        //TODO: dopisac kolor i przebieg i date
        car.setStatus(status);
        return carDAO.updateCar(car);
    }

    public boolean deleteCar(String id) {
        var car = getCarByID(id);
        return carDAO.deleteCar(car);
    }

    public boolean blockCar(String id) {
        var car = getCarByID(id);
        return carDAO.blockCar(car);
    }

    public List<Car> showCars() {
            return carDAO.showCars();

    }
}
