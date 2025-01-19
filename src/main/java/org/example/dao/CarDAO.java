package org.example.dao;

public interface CarDAO {
    void addCar(Car car);
    Car getCarById(int id); // Placeholder, can be customized
    void updateCar(Car car);
    void deleteCar(Car car);
    void blockCar(String nrRejestracyjny);
    void updateCarTechnicalState(Car car, java.sql.Date date);
}
