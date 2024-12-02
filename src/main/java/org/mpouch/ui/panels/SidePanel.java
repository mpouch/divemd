package org.mpouch.ui.panels;

import org.mpouch.ui.components.FileTree;

import javax.swing.*;
import java.awt.*;

public class SidePanel extends JPanel {

    public SidePanel() {
        setLayout(new BorderLayout());
        add(new FileTree(), BorderLayout.CENTER);

        setPreferredSize(new Dimension(200, getHeight()));
    }
}
