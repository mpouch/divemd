package org.mpouch.ui.components;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class FileTree extends JTree {

    public FileTree() {

        // Placeholder nodes
        setRootVisible(true);
        setShowsRootHandles(true);
        setEditable(true);

    }
}
