package org.mpouch.ui.panels;

import org.mpouch.ui.components.FileTree;

import javax.swing.*;
import java.awt.*;

public class SidePanel extends JPanel {
    private static final SidePanel instance = new SidePanel();
    private final FileTree fileTree = new FileTree();

    public SidePanel() {
        createSidePanel();
    }

    public static SidePanel getInstance() {
        return instance;
    }

    public FileTree getFileTree() {
        return this.fileTree;
    }

    private void createSidePanel() {
        setLayout(new BorderLayout());

        JScrollPane jScrollPane = new JScrollPane(fileTree);
        add(jScrollPane, BorderLayout.CENTER);

        setPreferredSize(new Dimension(200, Short.MAX_VALUE));
    }
}
