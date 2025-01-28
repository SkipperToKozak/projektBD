package org.example.gui.employee.panels.listElements;


import org.example.gui.employee.dialogs.ClientCarsListDialog;
import org.example.gui.employee.panels.ClientCarsListPanel;


import javax.swing.*;
import java.awt.*;

public class ClientInfoPanel extends JPanel {
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel PESELLabel;
    private JPanel buttonPanel;

    private JButton detailsButton;



    public ClientInfoPanel(String name, String surname, String PESEL) {
        super();
        nameLabel = new JLabel("Imię: " + name);
        surnameLabel = new JLabel("Nazwisko: " + surname);
        PESELLabel = new JLabel("PESEL: " + PESEL);

        setBackground(new Color(251, 179, 105, 255));

        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createRaisedBevelBorder());
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createEmptyBorder()));
//        setBackground(Color.CYAN);
        setMaximumSize(new Dimension(550, 90));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 10, 5, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nameLabel, gbc);

        gbc.gridx = 1;
        add(surnameLabel, gbc);

        gbc.gridx = 2;
        add(PESELLabel, gbc);

        gbc.gridwidth = 3;
        gbc.gridx = 0;
        gbc.gridy = 3;
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        add(buttonPanel, gbc);


        buttonPanel.setBackground(new Color(251, 179, 105, 255));
        detailsButton = new JButton("Szczegóły");
        buttonPanel.add(detailsButton);
        detailsButton.addActionListener(e -> {
            ClientCarsListDialog dialog = new ClientCarsListDialog();
            dialog.setVisible(true);
        });

        // Ustaw preferowany rozmiar (opcjonalnie)
        setPreferredSize(new Dimension(300, 60));

    }
}
