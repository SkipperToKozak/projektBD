package org.example.presenter.shared;

import org.example.dao.UserDAOImpl;
import org.example.gui.shared.LoginForm;
import org.example.gui.shared.RegisterForm;
import org.example.model.User;
import org.example.presenter.client.ClientPresenter;
import org.example.presenter.employee.EmployeePresenter;

import javax.swing.*;

public class LoginPresenter {
    private LoginForm loginForm;
    private ClientPresenter clientPresenter;
    private EmployeePresenter employeePresenter;
    private User user;
    private UserDAOImpl userDAO = new UserDAOImpl();
    private RegisterForm registerForm;
    private String login;
    private String password;
    public LoginPresenter() {
        SwingUtilities.invokeLater(() -> {
            loginForm = new LoginForm();
            invokeListener();
        });
        System.out.println("LoginPresenter created");

    }
    public void invokeListener() {
        loginForm.setOKButtonActionListener(e -> {
            onLoginButtonClicked();
        });
        loginForm.getRegisterLabel().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onGoToRegistrationButtonClicked();
            }
        });
//        loginForm.setRegisterButtonActionListener(e -> {
//            onRegisterButtonClicked();
//        });
    }

//    public boolean login(String login, String password) {
//        System.out.println("Logowanie...");
//        return true;
//    }
    public void onLoginButtonClicked() {
        String url = "jdbc:postgresql://localhost:5432/test1";
        user = userDAO.getUserByLogin(loginForm.getUsernameField().getText());
        if (user == null) {
            System.out.println("Niepoprawne dane logowania");
            loginForm.getConsoleLogLabel().setText("Niepoprawne dane logowania");
        }
        if (!user.getPassword().equals(loginForm.getPasswordField().getText())) {
            System.out.println("Niepoprawne dane logowania");
            loginForm.getConsoleLogLabel().setText("Niepoprawne dane logowania");
        }
        if (user.getPassword().equals(loginForm.getPasswordField().getText())) {
            System.out.println("Zalogowano");
            loginForm.getConsoleLogLabel().setText("Zalogowano");
            if (user.getRole().equals("employee")) {
                System.out.println("Jesteś zalogowany jako admin");
                loginForm.setVisible(false);
                employeePresenter = new EmployeePresenter(user);
            }
            if (user.getRole().equals("client")) {
                System.out.println("Jesteś zalogowany jako klient");
                loginForm.setVisible(false);
                clientPresenter = new ClientPresenter(user);

            }
        }

//        try (Connection connection = DriverManager.getConnection(url, loginForm.getUsernameField().getText(), loginForm.getPasswordField().getText())) {
//            System.out.println("Połączono z bazą danych PostgreSQL!");
//            loginForm.getConsoleLogLabel().setText("Połączono z bazą danych PostgreSQL!");
//
//
//
//
//        } catch (SQLException e1) {
//            System.err.println("Nie udało się połączyć: " + e1.getMessage());
//            loginForm.getConsoleLogLabel().setText("Nie udało się połączyć: " + e1.getMessage());
//        }



    }

    public void onGoToRegistrationButtonClicked() {
        System.out.println("Rejestracja...");
        loginForm.setVisible(false);
        SwingUtilities.invokeLater(() -> {
            registerForm = new RegisterForm();
            registerForm.setVisible(true);
            invokeRegisterListener();
        });


    }


    private void invokeRegisterListener() {
        registerForm.setRegisterButtonActionListener(e -> {
            onRegisterButtonClicked();
        });
    }
    private void onRegisterButtonClicked() {
        user = userDAO.getUserByLogin(loginForm.getUsernameField().getText());
        if (user == null) {
            System.out.println("Rejestrowanie...");
            loginForm.getConsoleLogLabel().setText("Rejestrowanie...");
            userDAO.addUser(new User(registerForm.getUsernameField().getText(), "haslo",
                    registerForm.getNameField().getText(), registerForm.getSurnameField().getText(), "employee",
                    registerForm.getPeselField().getText()));
        }
    }
}
