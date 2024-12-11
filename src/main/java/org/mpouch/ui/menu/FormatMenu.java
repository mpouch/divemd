package org.mpouch.ui.menu;

import javax.swing.*;

public class FormatMenu extends JMenu {

    public FormatMenu() {
        super("Format");
        createFormatMenu();
    }

    private void createFormatMenu() {
        JMenuItem link = new JMenuItem("Link");
        link.setAccelerator(KeyStroke.getKeyStroke("ctrl K"));

        JMenuItem bold = new JMenuItem("Bold");
        bold.setAccelerator(KeyStroke.getKeyStroke("ctrl B"));

        JMenuItem italic = new JMenuItem("Italic");
        italic.setAccelerator(KeyStroke.getKeyStroke("ctrl I"));

        JMenu headings = new JMenu("Headings");

        JMenuItem heading1 = new JMenuItem("Heading 1");
        heading1.setAccelerator(KeyStroke.getKeyStroke("ctrl 1"));

        JMenuItem heading2 = new JMenuItem("Heading 2");
        heading2.setAccelerator(KeyStroke.getKeyStroke("ctrl 2"));

        JMenuItem heading3 = new JMenuItem("Heading 3");
        heading3.setAccelerator(KeyStroke.getKeyStroke("ctrl 3"));

        JMenuItem heading4 = new JMenuItem("Heading 4");
        heading4.setAccelerator(KeyStroke.getKeyStroke("ctrl 4"));

        JMenuItem heading5 = new JMenuItem("Heading 5");
        heading5.setAccelerator(KeyStroke.getKeyStroke("ctrl 5"));

        headings.add(heading1);
        headings.add(heading2);
        headings.add(heading3);
        headings.add(heading4);
        headings.add(heading5);

        JMenuItem bulletedList = new JMenuItem("Bulleted list");
        JMenuItem numberedList = new JMenuItem("Numbered list");
        JMenuItem checkboxList = new JMenuItem("Checkbox list");

        add(link);
        add(bold);
        add(italic);

        addSeparator();

        add(headings);

        addSeparator();

        add(bulletedList);
        add(numberedList);
        add(checkboxList);
    }
}
