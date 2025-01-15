package org.mpouch.ui;

import org.mpouch.ui.panels.BottomPanel;
import org.mpouch.ui.panels.CenterPanel;
import org.mpouch.ui.panels.SidePanel;
import org.mpouch.ui.panels.TopPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private static final MainFrame instance = new MainFrame();

    private MainFrame() {
        // Config
        setTitle("divemd");
        setSize(800, 600);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Top Panel
        TopPanel topPanel = TopPanel.getInstance();
        add(topPanel, BorderLayout.NORTH);

        // Center Panel
        CenterPanel centerPanel = CenterPanel.getInstance();
        //add(centerPanel, BorderLayout.CENTER);

        // Side Panel
        SidePanel sidePanel = SidePanel.getInstance();
        // add(sidePanel, BorderLayout.WEST);

        // Body split pane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidePanel, centerPanel);
        // splitPane.setBackground(Color.decode("#E0ECF8"));
        add(splitPane, BorderLayout.CENTER);

        // Bottom Panel
        BottomPanel bottomPanel = new BottomPanel();
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public static MainFrame getInstance() {
        return instance;
    }
}
