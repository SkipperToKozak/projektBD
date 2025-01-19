package org.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;

public class CarDAOImpl implements CarDAO {

    private final Connection connection;

    public CarDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addCar(Car car) {
        String sql = "{call dodajsamochod(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try (CallableStatement cs = connection.prepareCall(sql)) {
            cs.setString(1, car.getNrRejestracyjny());
            cs.setString(2, car.getMarka());
            cs.setString(3, car.getModel());
            cs.setInt(4, car.getRokProdukcji());
            cs.setString(5, car.getStatusSamochodu());
            cs.setString(6, car.getKolor());
            cs.setInt(7, car.getLiczbaMiejsc());
            cs.setInt(8, car.getMocSilnika());
            cs.setInt(9, car.getPrzebieg());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Car getCarById(int id) {
        // Implement if needed, perhaps using the 'wyswietl_samochody' function
        return null; // Placeholder
    }

    @Override
    public void updateCar(Car car) {
        // Update logic would involve changing car details, which might require custom SQL
        // since no direct SQL function matches this action.
    }

    @Override
    public void deleteCar(Car car) {
        String sql = "{call usunsamochod(?)}";
        try (CallableStatement cs = connection.prepareCall(sql)) {
            cs.setString(1, car.getNrRejestracyjny()); // Assuming id is related to nr_rejestracyjny
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void blockCar(String nrRejestracyjny) {
        String sql = "{call zablokuj_samochod(?)}";
        try (CallableStatement cs = connection.prepareCall(sql)) {
            cs.setString(1, nrRejestracyjny);
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Additional method for updating car's technical state
    public void updateCarTechnicalState(Car car, java.sql.Date date) {
        String sql = "{call aktualizuj_stan_techniczny_dobry(?, ?)}";
        try (CallableStatement cs = connection.prepareCall(sql)) {
            cs.setString(1, car.getNrRejestracyjny);
            cs.setDate(2, date);
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}