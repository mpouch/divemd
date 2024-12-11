package org.mpouch.ui.config;

import javax.swing.*;
import javax.swing.plaf.IconUIResource;

public class UIManagerConfig {

    public static void configureUI() {
        UIManager.put("Tree.paintLines", true);
        UIManager.put("Tree.showDefaultIcons", true);

        // Icons
        ImageIcon collapsedIcon = new ImageIcon(UIManagerConfig.class.getResource("/icons/bullet_toggle_plus.png"));
        ImageIcon expandedIcon = new ImageIcon(UIManagerConfig.class.getResource("/icons/bullet_toggle_minus.png"));
        ImageIcon openIcon = new ImageIcon(UIManagerConfig.class.getResource("/icons/folder.png"));
        ImageIcon closedIcon = new ImageIcon(UIManagerConfig.class.getResource("/icons/folder.png"));
        ImageIcon leafIcon = new ImageIcon(UIManagerConfig.class.getResource("/icons/page_white_text.png"));

        UIManager.put("Tree.collapsedIcon", new IconUIResource(collapsedIcon));
        UIManager.put("Tree.expandedIcon", new IconUIResource(expandedIcon));
        UIManager.put("Tree.openIcon", new IconUIResource(openIcon));
        UIManager.put("Tree.closedIcon", new IconUIResource(closedIcon));
        UIManager.put("Tree.leafIcon", new IconUIResource(leafIcon));

        // Tabs
    }
}
