package org.mpouch.ui.config;

import org.mpouch.services.utils.FileUtils;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.io.File;

public class FileTreeCellRenderer extends DefaultTreeCellRenderer {
    private final Icon directoryIcon = new ImageIcon(FileTreeCellRenderer.class.getResource("/icons/folder.png"));
    private final Icon fileIcon = new ImageIcon(FileTreeCellRenderer.class.getResource("/icons/page_white_text.png"));

    @Override
    public Component getTreeCellRendererComponent(
            JTree tree,
            Object value,
            boolean selected,
            boolean expanded,
            boolean leaf,
            int row,
            boolean hasFocus) {

        super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);

        // Custom config
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        Object nodeUserObject = node.getUserObject();

        if (nodeUserObject instanceof File file) {
            if (file.isDirectory()) {
                setText(FileUtils.getCleanFileName(file));
                setIcon(directoryIcon);
            } else if (file.getName().endsWith(".md")) {
                setText(FileUtils.getCleanFileName(file));
                setIcon(fileIcon);
            }
        }

        return this;
    }
}
