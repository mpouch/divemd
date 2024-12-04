package org.mpouch.ui.components;

import javax.swing.*;
import java.awt.*;

public class ToolBar extends JToolBar {

    public ToolBar() {
        setFloatable(false);
        setBackground(Color.decode("#DEE5F2"));

        add(createButton("/icons/arrow_left.png"));
        add(createButton("/icons/arrow_right.png"));
        add(createButton("/icons/house.png"));
        add(createButton("/icons/arrow_up.png"));

        add(createButton("/icons/add.png"));
        add(createButton("/icons/delete.png"));
        add(createButton("/icons/disk.png"));

        add(createButton("/icons/magnifier.png"));
        add(createButton("/icons/page_white_go.png"));

    }

    private JButton createButton(String path) {
        return new JButton(new ImageIcon(getClass().getResource(path)));
    }
}
