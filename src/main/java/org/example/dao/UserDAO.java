package org.example.dao;

public interface UserDAO {
    void addUser(User user);
    User getUserById(int id); // Placeholder, can be customized
    void updateUser(User user);
    void deleteUser(int id);  // Placeholder, implement delete logic as needed
}
