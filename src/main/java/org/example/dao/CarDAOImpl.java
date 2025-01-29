package org.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.List;

import org.example.model.Car;

public class CarDAOImpl implements CarDAO {

    private final Connection connection;

    public CarDAOImpl() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public boolean addCar(Car car) {
        String sql = "call dodajsamochod(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (CallableStatement cs = connection.prepareCall(sql)) {
            cs.setString(1, car.getId());
            cs.setString(2, car.getBrand());
            cs.setString(3, car.getModel());
            cs.setInt(4, car.getProductionYear());
            cs.setString(5, car.getStatus());
            cs.setString(6, car.getColor());
            cs.setInt(7, car.getSeatAmount());
            cs.setInt(8, car.getHorsePower());
            cs.setInt(9, car.getMileage());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Car getCarById(String id) {
        String sql = "SELECT * FROM cars WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Car(
                            rs.getString("nr_rejestracyjny"),
                            rs.getString("marka"),
                            rs.getString("model"),
                            rs.getInt("rok_produkcji"),
                            rs.getString("kolor"),
                            rs.getString("status_samochodu"),
                            rs.getInt("liczba_miejsc"),
                            rs.getInt("moc_silnika"),
                            rs.getInt("przebieg")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateCar(Car car) {
        String sql = "call aktualizuj_samochod(?, ?, ?, ?)";
        try (CallableStatement cs = connection.prepareCall(sql)) {
            cs.setString(1, car.getId());
            cs.setInt(2, car.getMileage());
            cs.setString(3, car.getColor());
            cs.setDate(4, car.getLastCarInspection());
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteCar(Car car) {
        String sql = "call usunsamochod(?)";
        try (CallableStatement cs = connection.prepareCall(sql)) {
            cs.setString(1, car.getId());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean blockCar(Car car) {
        String sql = "call zablokuj_samochod(?)";
        try (CallableStatement cs = connection.prepareCall(sql)) {
            cs.setString(1, car.getId());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateCarTechnicalState(Car car, java.sql.Date date) {
        String sql = "call aktualizuj_stan_techniczny_dobry(?, ?)";
        try (CallableStatement cs = connection.prepareCall(sql)) {
            cs.setString(1, car.getId());
            cs.setDate(2, date);
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        String sql = "select * from wyswietl_samochody()";

        try (CallableStatement cs = connection.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                Car car = new Car(
                        rs.getString("nr_rejestracyjny"),
                        rs.getString("marka"),
                        rs.getString("model"),
                        rs.getInt("rok_produkcji"),
                        rs.getString("kolor"),
                        rs.getString("status_samochodu"),
                        rs.getInt("liczba_miejsc"),
                        rs.getInt("moc_silnika"),
                        rs.getInt("przebieg")
                );
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    @Override
    public List<Car> getAvailableCars() {
        List<Car> cars = new ArrayList<>();
        String sql = "select * from wyswietl_samochody() where status_samochodu = 'dostepny'";

        try (CallableStatement cs = connection.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                Car car = new Car(
                        rs.getString("nr_rejestracyjny"),
                        rs.getString("marka"),
                        rs.getString("model"),
                        rs.getInt("rok_produkcji"),
                        rs.getString("kolor"),
                        rs.getString("status_samochodu"),
                        rs.getInt("liczba_miejsc"),
                        rs.getInt("moc_silnika"),
                        rs.getInt("przebieg")
                );
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }
}