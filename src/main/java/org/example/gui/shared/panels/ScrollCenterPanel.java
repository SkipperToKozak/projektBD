package org.example.gui.shared.panels;

import javax.swing.*;

public class ScrollCenterPanel extends JScrollPane {
    protected JPanel listPanel;

    public ScrollCenterPanel() {
        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        setViewportView(listPanel);


//        add(listPanel);




    }

    public JPanel getListPanel() {

        return listPanel;
    }
    public JScrollPane getScrollPane() {
        return this;
    }


}
