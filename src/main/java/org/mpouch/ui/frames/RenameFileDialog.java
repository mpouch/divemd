package org.mpouch.ui.frames;

import org.mpouch.controllers.NoteController;
import org.mpouch.ui.factories.ButtonFactory;

import javax.swing.*;
import java.awt.*;

public class RenameFileDialog extends JDialog {

    public RenameFileDialog(JFrame owner) {
        super(owner, "Rename file", true);
        setSize(280, 135);
        setMinimumSize(new Dimension(280, 135));
        setResizable(false);
        setLocationRelativeTo(owner);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Name panel
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel nameLabel = new JLabel("New name: ");
        JTextField nameTextField = new JTextField(15);

        namePanel.add(nameLabel);
        namePanel.add(nameTextField);

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton confirmButton = ButtonFactory.createButton("Confirm", e -> {
            String newFileName = nameTextField.getText().trim() + ".md";

            if (!nameTextField.getText().isEmpty()) {
                NoteController.renameFile(newFileName);
            }

            dispose();
        });

        JButton cancelButton = ButtonFactory.createButton("Cancel", e -> {
            dispose();
        });

        getRootPane().setDefaultButton(confirmButton);
        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);

        // Main structure
        mainPanel.add(namePanel);
        mainPanel.add(buttonPanel);
        add(mainPanel);
    }
}
