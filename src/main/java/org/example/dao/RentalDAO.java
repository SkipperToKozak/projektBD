package org.example.dao;

import org.example.model.Car;
import org.example.model.Rental;
import org.example.model.User;

import java.util.List;

public interface RentalDAO {
    boolean rentCar(Car car, User user);
    boolean returnCar(Car car, User user);
    List<Rental> getClientRentals(User client);
    Rental getClientRentalById(User client, int id);
    Rental getRentalById(int id);


}
