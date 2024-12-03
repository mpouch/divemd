package org.mpouch.ui.menu;

import javax.swing.*;

public class ToolsMenu extends JMenu {

    public ToolsMenu() {
        super("Tools");

        JMenuItem wordCount = new JMenuItem("Word count");
        JMenuItem spellcheck = new JMenuItem("Spellcheck");

        add(wordCount);
        add(spellcheck);
    }
}
