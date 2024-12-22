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
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        textArea.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce et rhoncus nibh, sed vehicula ex. Duis cursus convallis mauris, at porttitor lacus malesuada at.");
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
}
