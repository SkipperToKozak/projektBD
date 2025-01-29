package org.example.dao;

import org.example.model.Car;
import java.util.List;

public interface CarDAO {
    boolean addCar(Car car);
    Car getCarById(String id);
    boolean updateCar(Car car);
    boolean deleteCar(Car car);
    boolean blockCar(Car car);
    boolean updateCarTechnicalState(Car car, java.sql.Date date);
    List<Car> getCars();
    List<Car> getAvailableCars();
}
