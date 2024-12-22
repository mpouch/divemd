package org.mpouch.ui.panels;

import org.mpouch.ui.components.FileTree;

import javax.swing.*;
import java.awt.*;

public class SidePanel extends JPanel {

    public SidePanel() {
        createSidePanel();
    }

    private void createSidePanel() {
        setLayout(new BorderLayout());

        FileTree fileTree = new FileTree();
        JScrollPane jScrollPane = new JScrollPane(fileTree);
        add(jScrollPane, BorderLayout.CENTER);

        setPreferredSize(new Dimension(200, Short.MAX_VALUE));
    }
}
