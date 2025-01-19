package org.example.dao;

public interface ReservationDAO {
    void addReservation(Reservation reservation);
    Reservation getReservationById(int id); // Placeholder, can be customized
    void updateReservation(Reservation reservation);
    void deleteReservation(Reservation reservation);
    void rentCar(Car car, User user);
    void reserveCar(Car car, User user);
    void returnCar(Car car, User user);
}
