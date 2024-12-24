package org.mpouch.ui.components;

import javax.swing.*;
import java.awt.*;

public class NoteEditor extends JPanel {
    private final JTextArea textArea;
    private final JScrollPane scrollPane;

    public NoteEditor() {
        setLayout(new BorderLayout());
        textArea = new JTextArea();
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        scrollPane = new JScrollPane(textArea);

        add(scrollPane);
    }

    public void setContent(String content) {
        textArea.setText(content);

        // Positions the viewport at the start of the markdown file
        // Otherwise, it lands at the bottom of scrollPane
        textArea.setCaretPosition(0);
    }
}
