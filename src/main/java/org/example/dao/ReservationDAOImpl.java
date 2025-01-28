package org.example.dao;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class ReservationDAOImpl implements ReservationDAO {

    private final Connection connection;

    public ReservationDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addReservation(Reservation reservation) {
        String sql = "{call zarezerwujsamochod(?, ?)}";
        try (CallableStatement cs = connection.prepareCall(sql)) {
            cs.setString(1, reservation.getCarRegistrationNumber());
            cs.setString(2, reservation.getClientLogin());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Reservation getReservationById(int id) {
        // Implement if needed, possibly using 'wyswietl_rezerwacje_klienta'
        return null; // Placeholder
    }

    @Override
    public void updateReservation(Reservation reservation) {
        // Update logic might involve custom SQL or using the provided functions indirectly
    }

    @Override
    public void deleteReservation(Reservation reservation) {
        String sql = "{call anuluj_rezerwacje(?, ?)}";
        try (CallableStatement cs = connection.prepareCall(sql)) {
            cs.setString(1, reservation.getCarRegistrationNumber());
            cs.setString(2, reservation.getClientLogin());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rentCar(Car car, User user){
        String sql = "{call wyporzyczsamochod(?, ?)}";
        try (CallableStatement cs = connection.prepareCall(sql)) {
            cs.setString(1, car.getNrRejestracyjny()); // Assuming id is related to nr_rejestracyjny
            cs.setString(2, user.getLogin());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void reserveCar(Car car, User user){
        String sql = "{call zarezerwujsamochod(?, ?)}";
        try (CallableStatement cs = connection.prepareCall(sql)) {
            cs.setString(1, car.getNrRejestracyjny()); // Assuming id is related to nr_rejestracyjny
            cs.setString(2, user.getLogin());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void returnCar(Car car, User user){
        String sql = "{call oddajsamochod(?, ?)}";
        try (CallableStatement cs = connection.prepareCall(sql)) {
            cs.setString(1, car.getNrRejestracyjny()); // Assuming id is related to nr_rejestracyjny
            cs.setString(2, user.getLogin());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}