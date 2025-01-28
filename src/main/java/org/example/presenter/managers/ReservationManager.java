package org.example.presenter.managers;

import org.example.dao.*;
import org.example.model.Reservation;
import org.example.model.User;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
        var reservation = new Reservation(carId, userId, Date.valueOf(LocalDate.now()));
        return reservationDAO.addReservation(reservation);
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

    public boolean reserveCar(String carId, String userLogin) {
        var car = carDAO.getCarById(carId);
        var user = userDAO.getUserByLogin(userLogin);
        try {
            reservationDAO.reserveCar(car, user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean returnCar(String carId, String clientLogin) {
        var car = carDAO.getCarById(carId);
        var user = userDAO.getUserByLogin(clientLogin);
        try {
            reservationDAO.returnCar(car, user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean showClientReservations(User client) {
        try {
            reservationDAO.getClientReservations(client);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean showClientReservations(String clientLogin) {
        var client = userDAO.getUserByLogin(clientLogin);
        try {
            reservationDAO.getClientReservations(client);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean showClientRentals(String clientLogin) {
        var client = userDAO.getUserByLogin(clientLogin);
        try {
            reservationDAO.getClientRentals(client);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

}
