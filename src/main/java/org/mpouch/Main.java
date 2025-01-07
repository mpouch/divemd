package org.mpouch;

import com.formdev.flatlaf.FlatLightLaf;
import org.mpouch.ui.MainFrame;
import org.mpouch.ui.config.UIManagerConfig;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        try {
            UIManager.put("defaultFont", new Font("Dialog", Font.PLAIN, 13));
            UIManager.setLookAndFeel(new FlatLightLaf());
            UIManagerConfig.configureUI();
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }

        SwingUtilities.invokeLater(() -> {
            MainFrame frame = MainFrame.getInstance();
            frame.setVisible(true);
        });
    }
}