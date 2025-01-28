package org.example.dao;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    private final Connection connection;

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addUser(User user) {
        String sql = "{call dodaj_klienta(?, ?, ?, ?, ?)}";
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
    public User getUserById(int id) {
        // Implement if needed, perhaps using 'wyswietl_klientow'
        return null; // Placeholder
    }

    @Override
    public void updateUser(User user) {
        // Custom SQL or use of procedures not provided here
    }

    @Override
    public void deleteUser(int id) {
        // No direct SQL procedure for deleting users is provided, would need custom SQL
    }
}