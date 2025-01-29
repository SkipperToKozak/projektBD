package org.example.gui.employee.panels;

import org.example.gui.employee.dialogs.AddCarDialog;
import org.example.gui.shared.buttons.JGradientButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EmployeeMainPanel extends JFrame {
    private JPanel northPanel;
    private JPanel actionsPanel;
    private JButton availableCarsButton;
    private JButton clientsButton;
    private JPanel accountPanel;
    private JLabel myAccountLabel;
    private JButton myAccountButton;
    private JPanel centerPanel;
    private CardLayout cardLayout;
    private EmployeeCarsListPanel carsListPanel = new EmployeeCarsListPanel();
    private JGradientButton addCarButton;
    private AllClientsListPanel allClientsListPanel = new AllClientsListPanel();

    public EmployeeMainPanel(String username) {
        super();

        setTitle("Pracownik - Panel główny");

        setMinimumSize(new Dimension(1000, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

//        gbclayout mainpanel
        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);

        //gorny panel
        northPanel = new JPanel();

        northPanel.setLayout(new GridLayout(1, 2));
        add(northPanel, BorderLayout.NORTH);

        //panel z przyciskami
        actionsPanel = new JPanel();
        actionsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        availableCarsButton = new JButton("Dostępne samochody");
        clientsButton = new JButton("Klienci");
        addCarButton = new JGradientButton("Dodaj samochód", new Color(138, 237, 138));



        actionsPanel.add(availableCarsButton);
        actionsPanel.add(clientsButton);
        actionsPanel.add(addCarButton);

        GridBagConstraints gbc_actionsPanel = new GridBagConstraints();
        gbc_actionsPanel.gridx = 0;
        gbc_actionsPanel.gridy = 0;
        northPanel.add(actionsPanel, gbc_actionsPanel);


        accountPanel = new JPanel();
        accountPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 5));

        myAccountLabel = new JLabel("Witaj, " + username + "!");
        accountPanel.add(myAccountLabel);

        GridBagConstraints gbc_myAccountButton = new GridBagConstraints();
        gbc_myAccountButton.gridx = 0;
        gbc_myAccountButton.gridy = 1;
        myAccountButton = new JButton("Moje konto");
        accountPanel.add(myAccountButton, gbc_myAccountButton);

        northPanel.add(accountPanel);

        cardLayout = new CardLayout();
        centerPanel = new JPanel();
        centerPanel.setLayout(cardLayout);
        add(centerPanel, BorderLayout.CENTER);

        centerPanel.add(carsListPanel, "availableCarsListPanel");
        centerPanel.add(allClientsListPanel, "allClientsListPanel");

////        allClientsPanel = new AllClientsPanel();
//        centerPanel.add(myCarsPanel, "myCarsPanel");
//
////        rentedCarPanel = new RentedCarPanel("Polonez", "Caro", "1989");
//        centerPanel.add(rentedCarPanel, "rentedCarPanel");
//        cardLayout.show(centerPanel, "rentedCarPanel");

//        addCarButton.addActionListener(e -> {
//            AddCarDialog addCarDialog = new AddCarDialog();
//            addCarDialog.setVisible(true);

//            addCarDialog.setVisible(true);
//            addCarDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//            addCarDialog.setSize(400, 300);
//            addCarDialog.setLocationRelativeTo(null);
//            addCarDialog.setResizable(true);
//            addCarDialog.setAlwaysOnTop(true);
//            addCarDialog.setModal(true);
//        });

    }
    public void addCarPanel(JPanel panel) {
        add(panel, BorderLayout.CENTER);
        repaint();
        revalidate();
    }
    public JPanel getCenterPanel() {
        return centerPanel;
    }

    public EmployeeCarsListPanel getCarsListPanel() {
        return carsListPanel;
    }

    public void setCarsButtonListener(ActionListener listener) {
        availableCarsButton.addActionListener(listener);
    }

    public void showAvailableCarsPanel() {
        carsListPanel = new EmployeeCarsListPanel();
        cardLayout.show(centerPanel, "availableCarsListPanel");
        repaint();
        revalidate();
    }

    public AllClientsListPanel getAllClientsListPanel() {
        return allClientsListPanel;
    }

    public void setClientsButtonListener(ActionListener listener) {
        clientsButton.addActionListener(listener);
    }

    public void showAllClientsPanel() {
        allClientsListPanel = new AllClientsListPanel();
        cardLayout.show(centerPanel, "allClientsListPanel");
        repaint();
        revalidate();
    }

    public void setAddCarButtonListener(ActionListener listener) {
        addCarButton.addActionListener(listener);
    }

    public AddCarDialog getAddCarDialog() {
        return new AddCarDialog();
    }
}

