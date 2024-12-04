package org.mpouch.ui.menu;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class HelpMenu extends JMenu {

    public HelpMenu() {
        super("Help");

        JMenuItem content = new JMenuItem("Content");
        content.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));

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
