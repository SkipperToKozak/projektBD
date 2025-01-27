package org.example.model.managers;

public class UserManager {
    private final UserDAO userDAO;

    public UserManager(UserDAO userDAO) {
        this.userDAO = new UserDAOImpl();
    }

    public boolean showClients() {
        try {
            userDAO.showClients();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
