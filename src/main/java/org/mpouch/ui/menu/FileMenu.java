package org.mpouch.ui.menu;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class FileMenu extends JMenu {

    public FileMenu() {
        super("File");

        JMenuItem newInstance = new JMenuItem("New instance");
        JMenuItem openInstance = new JMenuItem("Open instance");
        JMenuItem openRecent = new JMenuItem("Recent");
        JMenuItem saveChanges = new JMenuItem("Save changes");

        JMenuItem exportAsPDF = new JMenuItem("Export as PDF");
        JMenuItem print = new JMenuItem("Print");
        JMenuItem properties = new JMenuItem("Properties");
        JMenuItem settings = new JMenuItem("Settings");

        JMenuItem quitInstance = new JMenuItem("Quit");

        add(newInstance);
        add(openInstance);
        add(openRecent);
        add(saveChanges);

        addSeparator();

        add(exportAsPDF);
        add(print);

        addSeparator();

        add(properties);
        add(settings);

        addSeparator();

        add(quitInstance);
    }
}
