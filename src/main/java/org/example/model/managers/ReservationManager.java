package org.example.model.managers;

import org.example.dao.CarDAO;
import org.example.model.Reservation;

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
        var reservation = new Reservation(carId, userId, LocalDateTime.now());
        try {
            reservationDAO.addReservation(reservation);
            return true;
        } catch (Exception e) {
            return false;
        }
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

    public boolean reserveCar(int carId, int userId) {
        var car = carDAO.getCarById(carId);
        var user = userDAO.getUserById(userId);
        try {
            reservationDAO.reserveCar(car, user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean returnCar(int carId, int userId) {
        var car = carDAO.getCarById(carId);
        var user = userDAO.getUserById(userId);
        try {
            reservationDAO.returnCar(car, user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean showReservations() {
        try {
            reservationDAO.showReservations();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean showClientReservations(int clientId) {
        var client = userDAO.getClientById(clientId);
        try {
            reservationDAO.getClientReservations(client);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean showClientHires(int clientId) {
        var client = userDAO.getClientById(clientId);
        try {
            reservationDAO.getClientHires(client);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

}
