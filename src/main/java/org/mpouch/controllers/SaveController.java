package org.mpouch.controllers;

import org.mpouch.services.SaveService;
import org.mpouch.ui.panels.CenterPanel;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class SaveController {
    private final SaveService saveService = new SaveService();
    private final CenterPanel centerPanel;

    public SaveController(CenterPanel centerPanel) {
        this.centerPanel = centerPanel;
    }

    public void saveNote() {
        String content = "centerPanel.getTextArea().getText();";

        String workDir = "";
        File directory = new File(workDir);

        if (!directory.exists()) {
            directory.mkdirs();
        }

        File fileToSave = new File(directory, "note.md");

        try {
            saveService.saveToFile(content, fileToSave);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
}
