package org.example.dao;

import org.example.model.Car;
import org.example.model.Reservation;
import org.example.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {

    private final Connection connection;

    public ReservationDAOImpl() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public boolean addReservation(Reservation reservation) {
        String sql = "call zarezerwujsamochod(?, ?)";
        try (CallableStatement cs = connection.prepareCall(sql)) {
            cs.setString(1, reservation.getCarId());
            cs.setString(2, reservation.getUserLogin());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Reservation getReservationById(int id) {
        //moze jeszcze
        return null;
    }

    @Override
    public Reservation getClientReservationById(User client, int id) {
        var rentals = getClientReservations(client);
        if (rentals == null || rentals.isEmpty()) {
            return null;
        }

        return rentals.stream()
                .filter(rent -> rent.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Reservation getClientRentalById(User client, int id) {
        var rentals = getClientRentals(client);
        if (rentals == null || rentals.isEmpty()) {
            return null;
        }

        return rentals.stream()
                .filter(rent -> rent.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean updateReservation(Reservation reservation) {
        // Update logic might involve custom SQL or using the provided functions indirectly
        return false;
    }

    @Override
    public boolean cancelReservation(Reservation reservation) {
        String sql = "call anuluj_rezerwacje(?, ?)";
        try (CallableStatement cs = connection.prepareCall(sql)) {
            cs.setString(1, reservation.getCarId());
            cs.setString(2, reservation.getUserLogin());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean rentCar(Car car, User user){
        String sql = "call wypozyczsamochod(?, ?)";
        try (CallableStatement cs = connection.prepareCall(sql)) {
            cs.setString(1, car.getId());
            cs.setString(2, user.getLogin());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean reserveCar(Car car, User user){
        String sql = "call zarezerwujsamochod(?, ?)";
        try (CallableStatement cs = connection.prepareCall(sql)) {
            cs.setString(1, car.getId());
            cs.setString(2, user.getLogin());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean returnCar(Car car, User user){
        String sql = "call oddajsamochod(?, ?)";
        try (CallableStatement cs = connection.prepareCall(sql)) {
            cs.setString(1, car.getId());
            cs.setString(2, user.getLogin());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Reservation> getClientReservations(User client) {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "select * from wyswietl_rezerwacje_klienta(?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, client.getLogin());

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Reservation reservation = new Reservation(
                            rs.getInt("id"),
                            rs.getString("samochody_nr_rejestracyjny"),
                            rs.getString("status_rezerwacji"),
                            rs.getString("klienci_login")
                    );
                    reservations.add(reservation);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }

    @Override
    public List<Reservation> getClientRentals(User client) {
        List<Reservation> rentals = new ArrayList<>();
        String sql = "select * from wyswietl_wypozyczenia_klienta(?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, client.getLogin());

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Reservation reservation = new Reservation(
                            rs.getInt("id"),
                            rs.getString("samochody_nr_rejestracyjny"),
                            rs.getString("status_wypozyczenia"),
                            rs.getString("klienci_login")
                    );
                    rentals.add(reservation);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentals;
    }
}