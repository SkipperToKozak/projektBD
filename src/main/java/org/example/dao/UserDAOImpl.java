package org.example.dao;

import org.example.model.Reservation;
import org.example.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserDAOImpl implements UserDAO {

    private final Connection connection;

    public UserDAOImpl() {
        connection = DatabaseConnection.getConnection();
    }

    @Override
    public void addUser(User user) {
        String sql = "call dodaj_klienta(?, ?, ?, ?, ?)";
        try (CallableStatement cs = connection.prepareCall(sql)) {
            cs.setString(1, user.getLogin());
            cs.setString(2, user.getPassword()); // Note: Storing passwords in plain text is not recommended. Use hashing.
            cs.setString(3, user.getLastName());
            cs.setString(4, user.getFirstName());
            cs.setString(5, user.getPesel());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserByLogin(String login) {
        var clients = getClients();
        if (clients == null || clients.isEmpty()) {
            return null;
        }

        //Zwraca klienta o pierwszym znalezionym loginie klienta
        return clients.stream()
                    .filter(client -> Objects.equals(client.getLogin(), login))
                    .findFirst()
                    .orElse(null);
    }

    @Override
    public void updateUser(User user) {
        // Custom SQL or use of procedures not provided here
    }

    @Override
    public void deleteUser(int id) {
        // No direct SQL procedure for deleting users is provided, would need custom SQL
    }

    @Override
    public List<User> getClients() {
        List<User> clients = new ArrayList<>();
        String sql = "select * from wyswietl_klientow()";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    var client = new User(
                            rs.getString("login"),
                            rs.getString("haslo"),
                            rs.getString("nazwisko"),
                            rs.getString("imie"),
                            "klient",
                            rs.getString("pesel")
                    );
                    clients.add(client);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }
}