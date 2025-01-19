package org.example.dao;

// DatabaseConnection.java
import java.sql.*;

public class DatabaseConnection {
    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/rentalsystem";
            String username = "root";
            String password = "password";
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
