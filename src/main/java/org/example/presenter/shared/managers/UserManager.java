package org.example.presenter.shared.managers;

import org.example.dao.UserDAO;
import org.example.dao.UserDAOImpl;
import org.example.model.User;

import java.util.List;

public class UserManager {
    private final UserDAO userDAO;

    public UserManager() {
        this.userDAO = new UserDAOImpl();
    }

    public List<User> getClients() {
        return userDAO.getClients();
    }

    public boolean addClient() {
        return false;
    }

    public boolean addEmployee() {
        return false;
    }
}
