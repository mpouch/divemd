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

        JButton confirmButton = ButtonFactory.createButton("Confirm", e -> {
        	String fileName = nameTextField.getText().trim();
        	String fileType = (String) typeDropdown.getSelectedItem();
        	
        	
        	/*
        	 * In case the user leaves the file name field empty, the default
        	 * given name will be "Untitled". If there already is a file named "Untitled",
        	 * then it will be name "Untitled 1", "Untitled 2" and so on.
        	 */
        	if (fileName.length() != 0) {
        		NoteController.createFile(fileName, fileType);
        	} else {
        		fileName = "Untitled";
        		int fileCount = 1;
        		
        		while (!NoteController.createFile(fileName, fileType)) {
        			fileName = "Untitled " + fileCount;
        			fileCount ++;
        		}
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
        mainPanel.add(typePanel);
        mainPanel.add(buttonPanel);

        add(mainPanel);
    }
}
