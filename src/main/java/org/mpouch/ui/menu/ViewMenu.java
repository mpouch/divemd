package org.mpouch.ui.menu;

import javax.swing.*;

public class ViewMenu extends JMenu {

    public ViewMenu() {
        super("View");

        JMenuItem switchPreview = new JMenuItem("Switch preview");
        JMenuItem showToolBar = new JMenuItem("Show tool bar");
        JMenuItem showTree = new JMenuItem("Show tree");

        JMenuItem zoomIn = new JMenuItem("Zoom in");
        JMenuItem zoomOut = new JMenuItem("Zoom out");

        add(switchPreview);
        add(showToolBar);
        add(showTree);

        addSeparator();

        add(zoomIn);
        add(zoomOut);
    }

}
