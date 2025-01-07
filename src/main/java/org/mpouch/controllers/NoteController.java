package org.mpouch.controllers;

import org.mpouch.ui.MainFrame;
import org.mpouch.ui.config.AppConfig;
import org.mpouch.ui.frames.NewFileDialog;

import java.io.File;
import java.io.IOException;

public class NoteController {

    public static void promptFileCreation() {
        MainFrame mainWindow = MainFrame.getInstance();
        NewFileDialog newFileDialog = new NewFileDialog(mainWindow);
        newFileDialog.setVisible(true);
    }

    public void deleteFile() {
        // TODO: create delete file method
        System.out.println("Delete file");
    }

    // TODO: Handle permissions
    // TODO: remove redundant code
    public static void createFile(String fileName, String fileType) {
        if (fileType.equals("Note")) {

            try {
                File newNote = new File(AppConfig.getWorkdir() + "/" + fileName + ".md");

                if (newNote.createNewFile()) {
                    System.out.println("Created: " + newNote);
                } else {
                    System.out.println("Error. Note already exists or could not be created");
                }
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }

        } else if (fileType.equals("Directory")) {

            try {
                File newDirectory = new File(AppConfig.getWorkdir() + "/" + fileName);

                if (newDirectory.mkdir()) {
                    System.out.println("Created: " + newDirectory);
                } else {
                    System.out.println("Error. Directory already exists or could not be created");
                }
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }

        }
    }
}
