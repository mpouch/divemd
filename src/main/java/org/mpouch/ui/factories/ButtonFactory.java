package org.mpouch.ui.factories;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ButtonFactory {

    public static JButton createIconButton(String path, ActionListener actionListener) {
        JButton button = new JButton(new ImageIcon(ButtonFactory.class.getResource(path)));
        button.addActionListener(actionListener);
        return button;
    }

    public static JButton createButton(String label, ActionListener actionListener) {
        JButton button = new JButton(label);
        button.addActionListener(actionListener);
        return button;
    }
}
