package org.mpouch.ui.panels;

import javax.swing.*;

public class BottomPanel extends JPanel {

    public BottomPanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

        JLabel statusLabel = new JLabel("Ready");

        add(statusLabel);
    }
}
