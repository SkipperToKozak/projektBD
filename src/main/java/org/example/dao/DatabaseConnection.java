package org.example.dao;

// DatabaseConnection.java
import java.sql.*;

public class DatabaseConnection {
    public static Connection getConnection() {
        try {
            String url = "jdbc:postgresql://localhost:5432/test1";
            String username = "postgres";
            String password = "haslo";
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
