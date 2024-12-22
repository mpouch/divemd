package org.mpouch.ui.panels;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel {

    private JTextArea textArea;
    final JFileChooser fileChooser = new JFileChooser();

    public CenterPanel() {
        setLayout(new BorderLayout());
        createTabbedPane();
    }

    private void createTabbedPane() {
        textArea = new JTextArea();
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        textArea.setText("");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JTabbedPane tabbedPane = new JTabbedPane();
        JScrollPane scrollPane = new JScrollPane(textArea);
        tabbedPane.add("Note", scrollPane);
        add(tabbedPane, BorderLayout.CENTER);
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(String content) {
        textArea.setText(content);
    }
}
