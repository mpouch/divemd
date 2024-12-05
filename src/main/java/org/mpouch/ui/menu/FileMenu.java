package org.mpouch.ui.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FileMenu extends JMenu {

    public FileMenu() {
        super("File");

        JMenuItem newInstance = new JMenuItem("New instance");

        JMenuItem openInstance = new JMenuItem("Open instance");
        openInstance.setAccelerator(KeyStroke.getKeyStroke("ctrl alt O"));

        JMenu recentInstances = new JMenu("Recent");

        JMenuItem saveChanges = new JMenuItem("Save changes");
        saveChanges.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));

        JMenuItem exportAsPDF = new JMenuItem("Export as PDF");

        JMenuItem print = new JMenuItem("Print");
        print.setAccelerator(KeyStroke.getKeyStroke("ctrl alt P"));

        JMenuItem properties = new JMenuItem("Properties");

        JMenuItem settings = new JMenuItem("Settings");
        settings.setAccelerator(KeyStroke.getKeyStroke("ctrl alt S"));

        // Quit app
        JMenuItem quitInstance = new JMenuItem("Quit");
        quitInstance.setAccelerator(KeyStroke.getKeyStroke("ctrl Q"));

        quitInstance.addActionListener((ActionEvent e) -> {
            Window mainFrame = SwingUtilities.getWindowAncestor(this);
            mainFrame.dispose();
            System.exit(0);
        });

        add(newInstance);
        add(openInstance);
        add(recentInstances);
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
