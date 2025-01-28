package org.example.dao;

import org.example.model.Car;
import org.example.model.Reservation;
import org.example.model.User;

import java.util.List;

public interface ReservationDAO {
    boolean addReservation(Reservation reservation);
    Reservation getReservationById(int id); // Placeholder, can be customized
    Reservation getClientReservationById(User client, int id);
    Reservation getClientRentalById(User client, int id);
    boolean updateReservation(Reservation reservation);
    boolean cancelReservation(Reservation reservation);
    boolean rentCar(Car car, User user);
    boolean reserveCar(Car car, User user);
    boolean returnCar(Car car, User user);
    List<Reservation> getClientReservations(User client);
    List<Reservation> getClientRentals(User client);
}
