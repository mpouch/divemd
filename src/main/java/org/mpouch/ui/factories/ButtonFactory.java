package org.mpouch.ui.factories;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ButtonFactory {

    public static JButton createButton(String path, ActionListener actionListener) {
        JButton button = new JButton(new ImageIcon(ButtonFactory.class.getResource(path)));
        button.addActionListener(actionListener);
        return button;
    }
}
