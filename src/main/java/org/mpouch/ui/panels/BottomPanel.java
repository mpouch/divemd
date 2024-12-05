package org.mpouch.ui.panels;

import javax.swing.*;

public class BottomPanel extends JPanel {

    public BottomPanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

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
