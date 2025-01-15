package org.example.gui.client.panels;

import org.example.gui.client.panels.listElements.carPanel.RentedCarPanel;

import javax.swing.*;
import java.awt.*;

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
    private RentedCarPanel rentedCarPanel;
//    private JPanel currentCarPanel;
    private MyCarsPanel myCarsPanel;

    public ClientMainPanel(String username) {
        setTitle("Panel główny");
        setSize(800, 600);
        setMinimumSize(new Dimension(800, 600));
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
        actionsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
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

        rentedCarPanel = new RentedCarPanel("Polonez", "Caro", "1989");
        centerPanel.add(rentedCarPanel, "rentedCarPanel");
        cardLayout.show(centerPanel, "rentedCarPanel");


//        repaint();
//        revalidate();
        availableCarsButton.addActionListener(e -> {
            clientAvailableCarsListPanel = new ClientAvailableCarsListPanel();
            cardLayout.show(centerPanel, "clientAvailableCarsListPanel");
//            repaint();
//            revalidate();
        });
        myCarsButton.addActionListener(e -> {
            myCarsPanel = new MyCarsPanel();
            cardLayout.show(centerPanel, "myCarsPanel");
//            repaint();
//            revalidate();
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


}

