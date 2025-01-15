package org.mpouch.ui.panels;

import org.mpouch.ui.menu.MainMenu;
import org.mpouch.ui.components.ToolBar;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel {
    private static final TopPanel instance = new TopPanel();
    private final MainMenu mainMenu = new MainMenu();
    private final ToolBar toolBar = new ToolBar();

    public TopPanel() {
        createTopPanel();
    }

    public static TopPanel getInstance() {
        return instance;
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public ToolBar getToolBar() {
        return toolBar;
    }

    private void createTopPanel() {
        setLayout(new BorderLayout());

        add(mainMenu, BorderLayout.NORTH);
        add(toolBar, BorderLayout.SOUTH);
    }
}
