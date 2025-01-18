package org.mpouch.controllers;

import org.mpouch.services.utils.FileUtils;
import org.mpouch.ui.MainFrame;
import org.mpouch.ui.components.FileTree;
import org.mpouch.ui.config.AppConfig;
import org.mpouch.ui.frames.NewFileDialog;
import org.mpouch.ui.panels.CenterPanel;
import org.mpouch.ui.panels.SidePanel;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;
import java.io.IOException;

public class NoteController {
    private static final FileTree fileTree = SidePanel.getInstance().getFileTree();

    public static void promptFileCreation() {
        MainFrame mainWindow = MainFrame.getInstance();
        NewFileDialog newFileDialog = new NewFileDialog(mainWindow);
        newFileDialog.setVisible(true);
    }

    public static void deleteFile() {
    	// TODO: remove redundant code

        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) fileTree.getSelectionPath().getLastPathComponent();
        Object nodeUserObject = selectedNode.getUserObject();
        String fileName = FileUtils.getCleanFileName(((File) nodeUserObject));
        File file = (File) nodeUserObject;
        
        // Delete note
        if (!file.isDirectory()) {
            Object[] options = {"Confirm", "Cancel"};

            int option = JOptionPane.showOptionDialog(
                    MainFrame.getInstance(),
                    "Are you sure you want to delete \"" + fileName + "\"?",
                    "Delete file",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (option == 0) {

                // TODO: handle unopened notes
                if (file.getName().endsWith(".md")) {
                    CenterPanel.getInstance().closeNoteTab(file, fileName);
                }

                if (file.delete()) {
                    fileTree.updateModel();
                    System.out.println("File deleted");
                } else {
                	System.out.println("This directory contains files");
                }
            }
        } else { // Delete directory
            Object[] options = {"Confirm", "Cancel"};

            int option = JOptionPane.showOptionDialog(
                    MainFrame.getInstance(),
                    "Are you sure you want to delete \"" + fileName + "\"? All files inside will be deleted.",
                    "Delete file",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );
            
            if (option == 0) {
            	deleteDirectory(file);
            }
        }
    }
    
    private static void deleteDirectory(File file) {
    	File[] files = file.listFiles();
    	System.out.println("Directory: " + file);
    	
    	if (files != null) {
        	for (File f: files) {
        		if (f.isDirectory()) {
        			deleteDirectory(f);
        		} else {
        			if (f.delete()) {
        				fileTree.updateModel();
        				System.out.println("Deleted: " + f.getName());
        			} else {
        				System.out.println("Could not delete.");
        			}
        		}
        	}
    	}

        if (file.delete()) {
            fileTree.updateModel();
        }
    }

    // TODO: Handle unix permissions
    // TODO: remove redundant code
    // TODO: open new note in editor
    public static boolean createFile(String fileName, String fileType) {
        if (fileType.equals("Note")) {

            try {
                File newNote = new File(AppConfig.getWorkdir() + "/" + fileName + ".md");

                if (newNote.createNewFile()) {
                    fileTree.updateModel();
                    System.out.println("Created: " + newNote);
                    return true;
                } else {
                    System.out.println("Note already exists or could not be created");
                    return false;
                }
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
                return false;
            }

        } else if (fileType.equals("Directory")) {

            try {
                File newDirectory = new File(AppConfig.getWorkdir() + "/" + fileName);

                if (newDirectory.mkdir()) {
                    fileTree.updateModel();
                    System.out.println("Created: " + newDirectory);
                    return true;
                } else {
                    System.out.println("Directory already exists or could not be created");
                    return false;
                }
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
                return false;
            }

        }
        
        return false;
    }
}
