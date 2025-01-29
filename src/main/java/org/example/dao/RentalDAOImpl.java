package org.example.dao;

import org.example.model.Car;
import org.example.model.Rental;
import org.example.model.Reservation;
import org.example.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RentalDAOImpl implements RentalDAO {

    private Connection connection;

    public RentalDAOImpl() {
        this.connection = DatabaseConnection.getConnection();
    }



    @Override
    public Rental getClientRentalById(User client, int id) {
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
    public Rental getRentalById(int id) {
        return null;
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
    public List<Rental> getClientRentals(User client) {
        List<Rental> rentals = new ArrayList<>();
        String sql = "select * from wyswietl_wypozyczenia_klienta(?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, client.getLogin());

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    var rental = new Rental(
                            rs.getInt("id"),
                            rs.getString("samochody_nr_rejestracyjny"),
                            rs.getString("status_wypozyczenia"),
                            rs.getString("klienci_login")
                    );
                    rentals.add(rental);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentals;
    }
}
