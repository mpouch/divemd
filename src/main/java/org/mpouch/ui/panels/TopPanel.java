package org.mpouch.ui.panels;

import org.mpouch.ui.menu.MainMenu;
import org.mpouch.ui.components.ToolBar;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel {

    public TopPanel() {
        createTopPanel();
    }

    private void createTopPanel() {
        setLayout(new BorderLayout());
        add(new MainMenu(), BorderLayout.NORTH);
        add(new ToolBar(), BorderLayout.SOUTH);
    }
}
