package org.example.presenter.shared.managers;

import org.example.dao.UserDAO;
import org.example.dao.UserDAOImpl;

public class UserManager {
    private final UserDAO userDAO;

    public UserManager() {
        this.userDAO = new UserDAOImpl();
    }

    public boolean showClients() {
        try {
            userDAO.getClients();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addClient() {
        return false;
    }

    public boolean addEmployee() {
        return false;
    }
}
