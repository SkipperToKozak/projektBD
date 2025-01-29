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

    public User getUserByLogin(String login) {
        return userDAO.getUserByLogin(login);
    }

    public void addClient(User user) {
        userDAO.addUser(user);
    }

    public boolean addEmployee() {
        return false;
    }
}
