package org.mpouch.ui.frames;

import org.mpouch.controllers.NoteController;
import org.mpouch.ui.factories.ButtonFactory;

import javax.swing.*;
import java.awt.*;

public class NewFileDialog extends JDialog {

    public NewFileDialog(JFrame owner) {
        super(owner, "New file", true);
        setSize(280, 140);
        setMinimumSize(new Dimension(280, 140));
        setResizable(false);
        setLocationRelativeTo(owner);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Name panel
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel nameLabel = new JLabel("File name: ");
        JTextField nameTextField = new JTextField(15);

        namePanel.add(nameLabel);
        namePanel.add(nameTextField);

        // Type panel
        JPanel typePanel = new JPanel();
        typePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel typeLabel = new JLabel("File type: ");
        JComboBox<String> typeDropdown = new JComboBox<>();
        typeDropdown.addItem("Note");
        typeDropdown.addItem("Directory");

        typePanel.add(typeLabel);
        typePanel.add(typeDropdown);

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton cancelButton = ButtonFactory.createButton("Cancel", e -> {
            System.out.println("Action: Cancel");
            dispose();
        });

        JButton confirmButton = ButtonFactory.createButton("Confirm", e -> {
            System.out.println("Action: Confirm");
            NoteController.createFile(
                    nameTextField.getText().trim(),
                    (String) typeDropdown.getSelectedItem()
            );
            dispose();
        });

        buttonPanel.add(cancelButton);
        buttonPanel.add(confirmButton);

        // Structure
        mainPanel.add(namePanel);
        mainPanel.add(typePanel);
        mainPanel.add(buttonPanel);

        add(mainPanel);
    }
}
