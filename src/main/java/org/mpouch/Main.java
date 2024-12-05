package org.mpouch;

import com.formdev.flatlaf.FlatLightLaf;
import org.mpouch.ui.MainFrame;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        try {
            UIManager.put("defaultFont", new Font("Dialog", Font.PLAIN, 13));
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }

        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}