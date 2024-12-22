package org.mpouch.ui;

import org.mpouch.ui.panels.BottomPanel;
import org.mpouch.ui.panels.CenterPanel;
import org.mpouch.ui.panels.SidePanel;
import org.mpouch.ui.panels.TopPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    final CenterPanel centerPanel;

    public MainFrame() {
        // Config
        setTitle("divemd");
        setSize(800, 600);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Top Panel
        TopPanel topPanel = new TopPanel();
        add(topPanel, BorderLayout.NORTH);

        // Side Panel
        SidePanel sidePanel = new SidePanel();
        // add(sidePanel, BorderLayout.WEST);

        // Center Panel
        centerPanel = new CenterPanel();
        //add(centerPanel, BorderLayout.CENTER);

        // Body split pane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidePanel, centerPanel);
        // splitPane.setBackground(Color.decode("#E0ECF8"));
        add(splitPane, BorderLayout.CENTER);

        // Bottom Panel
        BottomPanel bottomPanel = new BottomPanel();
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public CenterPanel getCenterPanel() {
        return centerPanel;
    }
}