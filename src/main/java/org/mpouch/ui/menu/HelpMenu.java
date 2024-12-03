package org.mpouch.ui.menu;

import javax.swing.*;

public class HelpMenu extends JMenu {

    public HelpMenu() {
        super("Help");

        JMenuItem content = new JMenuItem("Content");
        JMenuItem keyboardShortcuts = new JMenuItem("Keyboard shortcuts");
        JMenuItem sourceCode = new JMenuItem("Source code");

        JMenuItem about = new JMenuItem("About");

        add(content);
        add(keyboardShortcuts);
        add(sourceCode);

        addSeparator();

        add(about);
    }
}
