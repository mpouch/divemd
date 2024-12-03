package org.mpouch.ui.menu;

import javax.swing.*;

public class MainMenu extends JMenuBar {

    public MainMenu() {

        // Menu
        add(new FileMenu());
        add(new EditMenu());
        add(new ViewMenu());
        add(new FormatMenu());
        add(new ToolsMenu());
        add(new HelpMenu());
    }
}
