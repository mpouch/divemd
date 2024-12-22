package org.mpouch.ui.components;

import org.mpouch.controllers.FileTreeController;
import org.mpouch.ui.config.FileTreeCellEditor;
import org.mpouch.ui.config.FileTreeCellRenderer;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class FileTree extends JTree {

    public FileTree() {
        FileTreeCellRenderer renderer = new FileTreeCellRenderer();
        FileTreeCellEditor editor = new FileTreeCellEditor(this, renderer);

        setCellRenderer(renderer);
        setCellEditor(editor);

        FileTreeController fileTreeController = new FileTreeController();
        String path = "/home/pouch/Documentos/swingtest";

        DefaultTreeModel model = fileTreeController.getTreeModel(path);
        setModel(model);

        setRootVisible(true);
        setShowsRootHandles(true);
        setEditable(true);

    }
}
