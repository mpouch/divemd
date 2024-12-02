package org.mpouch.ui.panels;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel {

    public CenterPanel() {

        setLayout(new BorderLayout());

        // Tabs
        JTabbedPane tabbedPane = new JTabbedPane();

        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        textArea.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce et rhoncus nibh, sed vehicula ex. Duis cursus convallis mauris, at porttitor lacus malesuada at.");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(textArea);

        tabbedPane.addTab("Note", scroll);

        add(tabbedPane, BorderLayout.CENTER);
    }
}
