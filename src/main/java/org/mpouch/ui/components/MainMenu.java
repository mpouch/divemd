package org.mpouch.ui.components;

import javax.swing.*;

public class MainMenu extends JMenuBar {

    public MainMenu() {

        // Menu
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu view = new JMenu("View");
        JMenu tools = new JMenu("Tools");
        JMenu window = new JMenu("Window");
        JMenu help = new JMenu("Help");

        add(file);
        add(edit);
        add(view);
        add(tools);
        add(window);
        add(help);
    }
}
