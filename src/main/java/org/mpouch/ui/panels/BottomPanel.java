package org.mpouch.ui.panels;

import javax.swing.*;

public class BottomPanel extends JPanel {
    private static final BottomPanel instance = new BottomPanel();
    private final JLabel backlinks = new JLabel("Backlinks: ");
    private final JLabel wordCount = new JLabel("Words: ");
    private final JLabel characterCount = new JLabel("Characters: ");
    private final JLabel createdDate = new JLabel("Created: ");
    private final JLabel modifiedDate = new JLabel("Modified: ");

    public BottomPanel() {
        createBottomPanel();
    }

    public static BottomPanel getInstance() {
        return instance;
    }

    public JLabel getBacklinks() {
        return backlinks;
    }

    public JLabel getWordCount() {
        return wordCount;
    }

    public JLabel getCharacterCount() {
        return characterCount;
    }

    public JLabel getCreatedDate() {
        return createdDate;
    }

    public JLabel getModifiedDate() {
        return modifiedDate;
    }

    private void createBottomPanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        // setBackground(Color.decode("#E0ECF8"));

        add(backlinks);
        add(wordCount);
        add(characterCount);
        add(createdDate);
        add(modifiedDate);
    }
}
