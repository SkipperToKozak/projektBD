package org.example;

import org.example.gui.client.panels.ClientMainPanel;
import org.example.gui.employee.panels.EmployeeMainPanel;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        LoginForm loginForm = new LoginForm();
        ClientMainPanel clientMainPanel = new ClientMainPanel("Test");
        EmployeeMainPanel employeeMainPanel = new EmployeeMainPanel("Test");


        }
}
