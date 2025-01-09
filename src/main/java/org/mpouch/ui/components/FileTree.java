package org.mpouch.ui.components;

import org.mpouch.controllers.FileTreeController;
import org.mpouch.services.utils.FileUtils;
import org.mpouch.ui.config.AppConfig;
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

        updateModel();

        setRootVisible(false);
        setShowsRootHandles(true);
        setEditable(false);

        addTreeSelectionListener(new FileTreeSelectionListener());
    }

    private static class FileTreeSelectionListener implements TreeSelectionListener {
        @Override
        public void valueChanged(TreeSelectionEvent e) {
            TreePath path = e.getPath();
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) path.getLastPathComponent();
            Object nodeUserObject = selectedNode.getUserObject();

            if (
                    nodeUserObject instanceof File file &&
                    file.getName().endsWith(".md") &&
                    file.exists()
            ) {
                try {
                    CenterPanel centerPanel = CenterPanel.getInstance();
                    String content = new String(Files.readAllBytes(file.toPath()));
                    centerPanel.openNote(file, FileUtils.getCleanFileName(file), content);
                } catch (IOException ex) {
                    System.err.println("FileTree Selection error: " + ex.getMessage());
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    public void updateModel() {
        FileTreeController fileTreeController = new FileTreeController();
        String path = AppConfig.getWorkdir();

        DefaultTreeModel model = fileTreeController.getTreeModel(path);
        setModel(model);

        System.out.println("Model updated");
    }
}
