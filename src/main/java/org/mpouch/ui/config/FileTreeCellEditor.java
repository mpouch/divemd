package org.mpouch.ui.config;

import org.mpouch.services.utils.FileUtils;
import org.mpouch.ui.panels.CenterPanel;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.io.File;
import java.util.Objects;

public class FileTreeCellEditor extends DefaultTreeCellEditor {
    private final Icon directoryIcon = new ImageIcon(Objects.requireNonNull(FileTreeCellRenderer.class.getResource("/icons/folder.png")));
    private final Icon fileIcon = new ImageIcon(Objects.requireNonNull(FileTreeCellRenderer.class.getResource("/icons/page_white_text.png")));

    public FileTreeCellEditor(JTree tree, DefaultTreeCellRenderer renderer) {
        super(tree, renderer);
    }

    // Custom config

    // Rename file
    // TODO: Handle IO exceptions and permissions
    @Override
    public Object getCellEditorValue() {
        TreePath editingPath = tree.getEditingPath();
        if (editingPath != null) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) editingPath.getLastPathComponent();
            Object nodeUserObject = node.getUserObject();

            if (nodeUserObject instanceof File file) {

                // Remove whitespace
                String newName = ((String) super.getCellEditorValue()).trim();
                
                // If the file is a markdown file, append ".md" to the file name
                if (file.getName().endsWith(".md")) {
                    newName += ".md";
                }

                File renamedFile = new File(file.getParentFile(), newName);
                file.renameTo(renamedFile);

                // If the file is a markdown file, trigger an update in the NoteEditor
                // to reflect the new note name in the tabbed pane
                if (file.getName().endsWith(".md")) {
                    requestNoteEditorUpdate(file, renamedFile);
                }

                return renamedFile;
            }
        }

        return super.getCellEditorValue();
    }

    // Configures the editing cell by setting the appropiate icon
    // and displaying the clean name of the file or directory
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
                    textField.setText(FileUtils.getCleanFileName(file));

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

    private static void requestNoteEditorUpdate(File file, File renamedFile) {
        CenterPanel centerPanel = CenterPanel.getInstance();
        String oldCleanName = FileUtils.getCleanFileName(file);
        String newCleanName = FileUtils.getCleanFileName(renamedFile);

        int tabIndex = centerPanel.getTabIndex(oldCleanName);
        centerPanel.updateNoteEditor(tabIndex, newCleanName);
        centerPanel.getNoteEditor().setEditingFile(renamedFile);
    }
}
