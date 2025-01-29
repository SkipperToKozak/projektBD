package org.example.presenter.shared.managers;

import org.example.dao.*;
import org.example.model.Car;
import org.example.model.Reservation;
import org.example.model.User;

import java.util.List;
import java.sql.Date;
import java.time.LocalDate;

public class ReservationManager {
    private final ReservationDAO reservationDAO;
    private final UserDAO userDAO;
    private final CarDAO carDAO;

    public ReservationManager() {
        reservationDAO = new ReservationDAOImpl();
        userDAO = new UserDAOImpl();
        carDAO = new CarDAOImpl();
    }

    public boolean addReservation(String carId, String userId) {
        return false; // niepotrzebne??
//        var reservation = new Reservation(carId, userId, Date.valueOf(LocalDate.now()));
//        return reservationDAO.addReservation(reservation);
    }

    public Reservation getReservationByID(int id) {
        try {
            return reservationDAO.getReservationById(id);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean updateReservation() {
        //???
        return false;
    }

    public boolean cancelReservation(int id) {
        var reservation = getReservationByID(id);
        try {
            reservationDAO.cancelReservation(reservation);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean reserveCar(Car car , String userLogin) {
        var user = userDAO.getUserByLogin(userLogin);
        try {
            reservationDAO.reserveCar(car, user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Reservation> getClientReservations(User client) {
        return reservationDAO.getClientReservations(client);
    }

    public List<Reservation> getClientReservations(String clientLogin) {
        var client = userDAO.getUserByLogin(clientLogin);
        return reservationDAO.getClientReservations(client);

    }

}
