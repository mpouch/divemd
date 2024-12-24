package org.mpouch.ui.components;

import org.mpouch.controllers.FileTreeController;
import org.mpouch.services.utils.FileUtils;
import org.mpouch.ui.config.FileTreeCellEditor;
import org.mpouch.ui.config.FileTreeCellRenderer;
import org.mpouch.ui.panels.CenterPanel;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileTree extends JTree {

    public FileTree() {
        createFileTree();
    }

    private void createFileTree() {
        FileTreeCellRenderer renderer = new FileTreeCellRenderer();
        FileTreeCellEditor editor = new FileTreeCellEditor(this, renderer);

        setCellRenderer(renderer);
        setCellEditor(editor);

        FileTreeController fileTreeController = new FileTreeController();
        String path = "";

        DefaultTreeModel model = fileTreeController.getTreeModel(path);
        setModel(model);

        setRootVisible(true);
        setShowsRootHandles(true);
        setEditable(true);

        addTreeSelectionListener(new FileTreeSelectionListener());
    }

    private class FileTreeSelectionListener implements TreeSelectionListener {
        @Override
        public void valueChanged(TreeSelectionEvent e) {
            TreePath path = e.getPath();
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) path.getLastPathComponent();
            Object nodeUserObject = selectedNode.getUserObject();

            if (nodeUserObject instanceof File) {
                File file = (File) nodeUserObject;
                if (file.isFile() && file.getName().endsWith(".md")) {
                    try {
                        CenterPanel centerPanel = CenterPanel.getInstance();
                        String content = new String(Files.readAllBytes(file.toPath()));
                        centerPanel.openNote(FileUtils.getCleanFileName(file), content);
                        // System.out.println(content);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        }
    }
}
