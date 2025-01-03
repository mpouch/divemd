package org.mpouch.controllers;

import org.mpouch.services.SaveService;
import org.mpouch.ui.panels.CenterPanel;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class SaveController {
    private final SaveService saveService = new SaveService();
    private final CenterPanel centerPanel;

    public SaveController() {
        this.centerPanel = CenterPanel.getInstance();
    }

    public void saveNote() {
        File currentFile = centerPanel.getNoteEditor().getEditingFile();
        String content = centerPanel.getNoteContent();

        try {
            saveService.saveToFile(content, currentFile);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
}
