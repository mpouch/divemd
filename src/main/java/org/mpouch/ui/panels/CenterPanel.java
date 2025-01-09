package org.mpouch.ui.panels;

import org.mpouch.ui.components.NoteEditor;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class CenterPanel extends JPanel {
    private static final CenterPanel instance = new CenterPanel();
    private final JTabbedPane tabbedPane;

    private CenterPanel() {
        setLayout(new BorderLayout());
        tabbedPane = new JTabbedPane();
        add(tabbedPane, BorderLayout.CENTER);
    }

    public static CenterPanel getInstance() {
        return instance;
    }

    // Open note
    public void openNote(File file, String title, String content) {
        if (tabbedPane.getTabCount() == 0) {
            openNoteInNewTab(file, title, content);
        } else {
            openNoteInSelectedTab(file, title, content);
        }
    }

    public void openNoteInNewTab(File file, String title, String content) {
        NoteEditor noteEditor = new NoteEditor(file);
        noteEditor.setContent(content);
        tabbedPane.addTab(title, noteEditor);
    }

    public void openNoteInSelectedTab(File file, String title, String content) {
        Component selectedComponent = tabbedPane.getSelectedComponent();

        if (selectedComponent instanceof NoteEditor selectedNoteEditor) {
            selectedNoteEditor.setContent(content);
            selectedNoteEditor.setEditingFile(file);

            int selectedIndex = tabbedPane.getSelectedIndex();
            tabbedPane.setTitleAt(selectedIndex, title);
        }
    }

    public void closeNoteTab(File file, String title) {
        if (!file.isDirectory()) {
            tabbedPane.removeTabAt(getTabIndex(title));
        }
    }

    // Get note title and content - DEPRECATED

    public String getNoteTitle() {
        int selectedIndex = tabbedPane.getSelectedIndex();
        return tabbedPane.getTitleAt(selectedIndex);
    }

    // Used in case the user renames a note in the file tree

    public String getNoteContent() {
        Component selectedComponent = tabbedPane.getSelectedComponent();

        if (selectedComponent instanceof NoteEditor selectedNoteEditor) {
            return selectedNoteEditor.getContent();
        }

        return "";
    }

    // Get NoteEditor

    public NoteEditor getNoteEditor() {
        Component selectedComponent = tabbedPane.getSelectedComponent();

        if (selectedComponent instanceof NoteEditor selectedNoteEditor) {
            return selectedNoteEditor;
        }
        return null;
    }

    public int getTabIndex(String title) {
        return tabbedPane.indexOfTab(title);
    }

    public void updateNoteEditor(int tabIndex, String newTitle) {
        tabbedPane.setTitleAt(tabIndex, newTitle);
    }
}
