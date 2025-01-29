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
        if (user.getRole() == "client") {
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
        } else if (user.getRole() == "employee") {
            String sql = "INSERT INTO public.pracownicy(\n" +
                    "    login, haslo, nazwisko, imie)\n" +
                    "    VALUES (?, ?, ?, ?);";
            try (CallableStatement cs = connection.prepareCall(sql)) {
                cs.setString(1, user.getLogin());
                cs.setString(2, user.getPassword()); // Note: Storing passwords in plain text is not recommended. Use hashing.
                cs.setString(3, user.getLastName());
                cs.setString(4, user.getFirstName());
                cs.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public User getUserByLogin(String login) {
        var clients = getClients();
        var employees = getEmployees();

        //Zwraca klienta lub pracownika o pierwszym znalezionym loginie
        var client = clients.stream()
                    .filter(cli -> Objects.equals(cli.getLogin(), login))
                    .findFirst()
                    .orElse(null);

        var employee = employees.stream()
                .filter(emp -> Objects.equals(emp.getLogin(), login))
                .findFirst()
                .orElse(null);

        if (client != null) {
            return client;
        } else {
            return employee;
        }
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
                            "client",
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

    @Override
    public List<User> getEmployees() {
        List<User> employees = new ArrayList<>();
        String sql = "select * from pracownicy";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    var employee = new User(
                            rs.getString("login"),
                            rs.getString("haslo"),
                            rs.getString("nazwisko"),
                            rs.getString("imie"),
                            "employee"
                    );
                    employees.add(employee);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}