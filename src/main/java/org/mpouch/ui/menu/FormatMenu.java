package org.mpouch.ui.menu;

import javax.swing.*;

public class FormatMenu extends JMenu {

    public FormatMenu() {
        super("Format");

        JMenuItem link = new JMenuItem("Link");
        JMenuItem bold = new JMenuItem("Bold");
        JMenuItem italic = new JMenuItem("Italic");

        JMenu headings = new JMenu("Headings");
        JMenuItem heading1 = new JMenuItem("Heading 1");
        JMenuItem heading2 = new JMenuItem("Heading 2");
        JMenuItem heading3 = new JMenuItem("Heading 3");
        JMenuItem heading4 = new JMenuItem("Heading 4");
        JMenuItem heading5 = new JMenuItem("Heading 5");

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
