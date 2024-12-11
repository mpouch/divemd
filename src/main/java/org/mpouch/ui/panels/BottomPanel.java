package org.mpouch.ui.panels;

import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel {

    public BottomPanel() {
        createBottomPanel();
    }

    private void createBottomPanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        // setBackground(Color.decode("#E0ECF8"));

        JLabel backlinks = new JLabel("Backlinks: ");
        JLabel wordCount = new JLabel("Words: ");
        JLabel characterCount = new JLabel("Characters: ");
        JLabel createdDate = new JLabel("Created: ");
        JLabel modifiedDate = new JLabel("Modified: ");

        add(backlinks);
        add(wordCount);
        add(characterCount);
        add(createdDate);
        add(modifiedDate);
    }
}
