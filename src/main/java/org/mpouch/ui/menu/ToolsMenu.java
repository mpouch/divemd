package org.mpouch.ui.menu;

import javax.swing.*;

public class ToolsMenu extends JMenu {

    public ToolsMenu() {
        super("Tools");
        createToolsMenu();
    }

    private void createToolsMenu() {
        JMenuItem wordCount = new JMenuItem("Word count");
        wordCount.setAccelerator(KeyStroke.getKeyStroke("ctrl shift C"));

        JMenuItem spellcheck = new JMenuItem("Spellcheck");
        spellcheck.setAccelerator(KeyStroke.getKeyStroke("ctrl alt X"));

        add(wordCount);
        add(spellcheck);
    }
}
