package org.mpouch.ui.panels;

import org.mpouch.ui.components.MainMenu;
import org.mpouch.ui.components.ToolBar;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel {

    public TopPanel() {
        setLayout(new BorderLayout());

        add(new MainMenu(), BorderLayout.NORTH);
        add(new ToolBar(), BorderLayout.SOUTH);
    }
}
