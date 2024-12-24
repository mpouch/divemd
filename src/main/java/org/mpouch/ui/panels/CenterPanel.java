package org.mpouch.ui.panels;

import org.mpouch.ui.components.NoteEditor;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel {
    private static CenterPanel instance;
    private final JTabbedPane tabbedPane;

    public CenterPanel() {
        setLayout(new BorderLayout());
        tabbedPane = new JTabbedPane();
        add(tabbedPane, BorderLayout.CENTER);

        // Testing
        addNoteTab("Welcome", "# Welcome\n\nNote content A");
        addNoteTab("Format", "Note content B");
    }

    public static CenterPanel getInstance() {
        if (instance == null) {
            instance = new CenterPanel();
        }
        return instance;
    }

    public void addNoteTab(String title, String content) {
        NoteEditor noteEditor = new NoteEditor();
        noteEditor.setContent(content);
        tabbedPane.addTab(title, noteEditor);
    }

    public void openNote(String title, String content) {
        Component selectedComponent = tabbedPane.getSelectedComponent();

        if (selectedComponent instanceof NoteEditor selectedNoteEditor) {
            selectedNoteEditor.setContent(content);

            int selectedIndex = tabbedPane.getSelectedIndex();
            tabbedPane.setTitleAt(selectedIndex, title);
        }
    }
}
