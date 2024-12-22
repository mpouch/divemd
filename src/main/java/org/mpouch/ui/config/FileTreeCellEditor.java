package org.mpouch.ui.config;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.io.File;

public class FileTreeCellEditor extends DefaultTreeCellEditor {
    private final Icon directoryIcon = new ImageIcon(FileTreeCellRenderer.class.getResource("/icons/folder.png"));
    private final Icon fileIcon = new ImageIcon(FileTreeCellRenderer.class.getResource("/icons/page_white_text.png"));

    public FileTreeCellEditor(JTree tree, DefaultTreeCellRenderer renderer) {
        super(tree, renderer);
    }

    // Custom config

    @Override
    public Object getCellEditorValue() {
        TreePath editingPath = tree.getEditingPath();
        if (editingPath != null) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) editingPath.getLastPathComponent();
            Object nodeUserObject = node.getUserObject();

            if (nodeUserObject instanceof File file) {
                String newName = (String) super.getCellEditorValue();

                File renamedFile = new File(file.getParentFile(), newName);
                if (file.renameTo(renamedFile)) {
                    return renamedFile;
                } else {
                    return file;
                }
            }
        }

        return super.getCellEditorValue();
    }

    @Override
    public Component getTreeCellEditorComponent(
            JTree tree, Object value, boolean isSelected,
            boolean expanded, boolean leaf, int row) {

        Component editorComponent = super.getTreeCellEditorComponent(tree, value, isSelected, expanded, leaf, row);

        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        Object nodeUserObject = node.getUserObject();

        if (nodeUserObject instanceof File file) {
            if (editorComponent instanceof DefaultTreeCellEditor.EditorContainer container) {
                Component nameEditor = container.getComponent(0);
                if (nameEditor instanceof JTextField textField) {
                    textField.setText(file.getName());

                    if (file.isDirectory()) {
                        editingIcon = directoryIcon;
                    } else {
                        editingIcon = fileIcon;
                    }
                }
            }
        }

        return editorComponent;
    }
}
