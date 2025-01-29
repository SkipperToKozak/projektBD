package org.example.gui.client.panels;

import org.example.gui.client.panels.listElements.carPanel.RentedCarPanel;
import org.example.model.Car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Date;

public class ClientMainPanel extends JFrame {
    private JPanel actionsPanel;
    private JPanel accountPanel;
    private JPanel northPanel;
    private JLabel myAccountLabel;
    private JButton availableCarsButton;
    private JButton myCarsButton;
    private JButton myAccountButton;
    private JPanel centerPanel;
    private CardLayout cardLayout;
    private ClientAvailableCarsListPanel clientAvailableCarsListPanel;

    private JPanel currentCarPanel;
    private RentedCarPanel rentedCarPanel;
    private ClientAccountPanel clientAccountPanel;

//    private JPanel currentCarPanel;
    private MyCarsPanel myCarsPanel;

    public ClientMainPanel(String username) {

        setTitle("Klient - Panel główny");
        setSize(800, 600);
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
        myCarsButton = new JButton("Moje samochody");

        actionsPanel.add(availableCarsButton);
        actionsPanel.add(myCarsButton);

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

        clientAvailableCarsListPanel = new ClientAvailableCarsListPanel();
        centerPanel.add(clientAvailableCarsListPanel, "clientAvailableCarsListPanel");

        myCarsPanel = new MyCarsPanel();
        centerPanel.add(myCarsPanel, "myCarsPanel");


        clientAccountPanel = new ClientAccountPanel("", "", "");
        centerPanel.add(clientAccountPanel, "clientAccountPanel");

//        rentedCarPanel = new RentedCarPanel(new Car("DW122", "Polonez", "Caro", 1982,"szary",
//                5, 50, 100, "wypozyczony", new Date(2021, 5, 5)));
//        centerPanel.add(rentedCarPanel, "rentedCarPanel");
        cardLayout.show(centerPanel, "myCarsPanel");


//        repaint();
//        revalidate();

//        myCarsButton.addActionListener(e -> {
//            myCarsPanel = new MyCarsPanel();
//
////            repaint();
////            revalidate();
//        });

        myAccountButton.addActionListener(e -> {
            clientAccountPanel = new ClientAccountPanel("", "", "");
            cardLayout.show(centerPanel, "clientAccountPanel");

        });

    }
    public void addCarPanel(JPanel panel) {
        add(panel, BorderLayout.CENTER);
        repaint();
        revalidate();
    }

    public JPanel getCenterPanel() {
        return centerPanel;
    }
    public void setAvailableCarsButtonListener(ActionListener listener) {

        availableCarsButton.addActionListener(listener);
    }
    public void setMyCarsButtonListener(ActionListener listener) {
        myCarsButton.addActionListener(listener);
    }
    public void setMyAccountButtonListener(ActionListener listener) {
        myAccountButton.addActionListener(listener);
    }
    public void showAvailableCarsPanel() {
//        clientAvailableCarsListPanel = new ClientAvailableCarsListPanel();
//        revalidate();
//        repaint();
        cardLayout.show(centerPanel, "clientAvailableCarsListPanel");
        centerPanel.revalidate();
        centerPanel.repaint();
        this.revalidate();
        this.repaint();
    }
    public void showMyCarsPanel() {
        cardLayout.show(centerPanel, "myCarsPanel");
        centerPanel.revalidate();
        centerPanel.repaint();
        this.revalidate();
        this.repaint();
    }

    public void refresh() {
        centerPanel.revalidate();
        centerPanel.repaint();
        this.revalidate();
        this.repaint();
    }

    public ClientAvailableCarsListPanel getClientAvailableCarsListPanel() {
        return clientAvailableCarsListPanel;
    }

    public void setClientAvailableCarsListPanel(ClientAvailableCarsListPanel clientAvailableCarsListPanel) {
        this.clientAvailableCarsListPanel = clientAvailableCarsListPanel;
    }

    public MyCarsPanel getMyCarsPanel() {
        return myCarsPanel;
    }
    public ClientAccountPanel getClientAccountPanel() {
        return clientAccountPanel;
    }


}

