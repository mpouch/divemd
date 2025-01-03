package org.mpouch.ui.components;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class NoteEditor extends JPanel {
    private final RSyntaxTextArea textArea;
    private File editingFile;

    public NoteEditor(File file) {
        setLayout(new BorderLayout());
        textArea = new RSyntaxTextArea();
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_MARKDOWN);
        textArea.setHighlightCurrentLine(false);
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        this.editingFile = file;

        JScrollPane scrollPane = new JScrollPane(textArea);

        add(scrollPane);
    }

    public String getContent() {
        return textArea.getText();
    }

    public void setContent(String content) {
        textArea.setText(content);

        // Positions the viewport at the start of the markdown file
        // Otherwise, it lands at the bottom of scrollPane
        textArea.setCaretPosition(0);
    }

    public File getEditingFile() {
        return this.editingFile;
    }

    public void setEditingFile(File file) {
        this.editingFile = file;
    }
}
