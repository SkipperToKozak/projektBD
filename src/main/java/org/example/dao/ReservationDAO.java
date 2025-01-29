package org.example.dao;

import org.example.model.Car;
import org.example.model.Reservation;
import org.example.model.User;

import java.util.List;

public interface ReservationDAO {
    Reservation getReservationById(int id);
    Reservation getClientReservationById(User client, int id);
    boolean updateReservation(Reservation reservation);
    boolean cancelReservation(Reservation reservation);
    boolean reserveCar(Car car, User user);
    List<Reservation> getClientReservations(User client);
}
