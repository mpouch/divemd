package org.mpouch.ui.menu;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JMenuBar {

    public MainMenu() {
        createMainMenu();
    }

    private void createMainMenu() {
        add(new FileMenu());
        add(new EditMenu());
        add(new ViewMenu());
        add(new FormatMenu());
        add(new ToolsMenu());
        add(new HelpMenu());
    }
}
