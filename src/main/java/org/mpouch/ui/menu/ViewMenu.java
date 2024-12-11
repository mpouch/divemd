package org.mpouch.ui.menu;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class ViewMenu extends JMenu {

    public ViewMenu() {
        super("View");
        createViewMenu();
    }

    private void createViewMenu() {
        JMenuItem switchPreview = new JMenuItem("Switch preview");
        switchPreview.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));

        JMenuItem showToolBar = new JMenuItem("Show tool bar");
        showToolBar.setAccelerator(KeyStroke.getKeyStroke("ctrl shift T"));

        JMenuItem showTree = new JMenuItem("Show tree");
        showTree.setAccelerator(KeyStroke.getKeyStroke("ctrl T"));

        JMenuItem zoomIn = new JMenuItem("Zoom in");
        zoomIn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, KeyEvent.CTRL_DOWN_MASK));

        JMenuItem zoomOut = new JMenuItem("Zoom out");
        zoomOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, KeyEvent.CTRL_DOWN_MASK));

        add(switchPreview);
        add(showToolBar);
        add(showTree);

        addSeparator();

        add(zoomIn);
        add(zoomOut);
    }

}
