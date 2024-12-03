package org.mpouch.ui.menu;

import javax.swing.*;

public class EditMenu extends JMenu {

    public EditMenu() {
        super("Edit");

        JMenuItem undo = new JMenuItem("Undo");
        JMenuItem redo = new JMenuItem("Redo");

        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");

        add(undo);
        add(redo);

        addSeparator();

        add(cut);
        add(copy);
        add(paste);
    }
}
