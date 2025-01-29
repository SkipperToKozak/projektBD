package org.example.dao;

import org.example.model.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);
    User getUserByLogin(String login);
    void updateUser(User user);
    void deleteUser(int id);
    List<User> getClients();
    List<User> getEmployees();
}
