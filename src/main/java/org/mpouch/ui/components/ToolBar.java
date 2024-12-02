package org.mpouch.ui.components;

import javax.swing.*;

public class ToolBar extends JToolBar {

    public ToolBar() {
        setFloatable(false);

        JButton backButton = new JButton("Back");
        JButton forwardButton = new JButton("Forward");
        JButton homeButton = new JButton("Home");
        JButton upButton = new JButton("Up");

        JButton newButton = new JButton("New note");
        JButton deleteButton = new JButton("Delete note");
        JButton saveButton = new JButton("Save");

        JButton searchButton = new JButton("Search");
        JButton goButton = new JButton("Go");

        add(backButton);
        add(forwardButton);
        add(homeButton);

        add(newButton);
        add(deleteButton);
        add(saveButton);

        add(searchButton);
        add(goButton);

    }
}
