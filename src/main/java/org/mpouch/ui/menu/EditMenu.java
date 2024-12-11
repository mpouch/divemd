package org.mpouch.ui.menu;

import javax.swing.*;

public class EditMenu extends JMenu {

    public EditMenu() {
        super("Edit");
        createEditMenu();
    }

    private void createEditMenu() {
        JMenuItem undo = new JMenuItem("Undo");
        undo.setAccelerator(KeyStroke.getKeyStroke("ctrl Z"));

        JMenuItem redo = new JMenuItem("Redo");
        redo.setAccelerator(KeyStroke.getKeyStroke("ctrl Y"));

        JMenuItem cut = new JMenuItem("Cut");
        cut.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));

        JMenuItem copy = new JMenuItem("Copy");
        copy.setAccelerator(KeyStroke.getKeyStroke("ctrl C"));

        JMenuItem paste = new JMenuItem("Paste");
        paste.setAccelerator(KeyStroke.getKeyStroke("ctrl V"));

        add(undo);
        add(redo);

        addSeparator();

        add(cut);
        add(copy);
        add(paste);
    }
}
