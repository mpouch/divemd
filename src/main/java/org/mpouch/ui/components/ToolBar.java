package org.mpouch.ui.components;

import org.mpouch.controllers.NoteController;
import org.mpouch.controllers.SaveController;
import org.mpouch.ui.factories.ButtonFactory;

import javax.swing.*;
import java.awt.*;

public class ToolBar extends JToolBar {

    public ToolBar() {
        setFloatable(false);
        // setBackground(Color.decode("#E0ECF8"));
        configureButtons();
        configureSearchField();
    }

    private void configureButtons() {
    	/* Navegation */
    	
        JButton backButton = ButtonFactory.createIconButton("/icons/arrow_left.png", e -> {
        	System.out.println("Action: Go back");
        });
        add(backButton);
        
        JButton forwardButton = ButtonFactory.createIconButton("/icons/arrow_right.png", e -> {
        	System.out.println("Action: Go forward");
        });
        add(forwardButton);
        
        JButton homeButton = ButtonFactory.createIconButton("/icons/house.png", e -> {
        	System.out.println("Action: Go to Home");
        });
        add(homeButton);
        
        JButton upButton = ButtonFactory.createIconButton("/icons/arrow_up.png", e -> {
        	System.out.println("Action: Go up");
        });
        add(upButton);

        addSeparator();
        
        /* Create, delete and save notes */

        // Create file
        JButton createButton = ButtonFactory.createIconButton("/icons/add.png", e -> {
        	System.out.println("Action: Create note");
            NoteController.promptFileCreation();
        });
        add(createButton);

        // Delete file
        JButton deleteButton = ButtonFactory.createIconButton("/icons/delete.png", e -> {
        	System.out.println("Action: Delete note");
            NoteController.promptFileCreation();
        });
        add(deleteButton);
        
        JButton saveButton = ButtonFactory.createIconButton("/icons/disk.png", e-> {
        	System.out.println("Action: Save note");
            SaveController saveController = new SaveController();
            saveController.saveNote();
        });
        add(saveButton);

        addSeparator();
        
        /* Search, go and bookmark */
        
        JButton globalSearchButton = ButtonFactory.createIconButton("/icons/magnifier.png", e -> {
        	System.out.println("Action: Global search");
        });
        add(globalSearchButton);
        
        JButton openNoteButton = ButtonFactory.createIconButton("/icons/page_white_go.png", e -> {
        	System.out.println("Action: Open note/Quick switcher");
        });
        add(openNoteButton);
        
        JButton bookmarkNoteButton = ButtonFactory.createIconButton("/icons/folder_star.png", e -> {
        	System.out.println("Action: Bookmark note");
        });
        add(bookmarkNoteButton);

        addSeparator();
        
        /* Editor actions */
        
        JButton linkNote = ButtonFactory.createIconButton("/icons/link.png", e -> {
        	System.out.println("Action: Link note");
        });
        add(linkNote);
        
        JButton boldTextButton = ButtonFactory.createIconButton("/icons/text_bold.png", e -> {
        	System.out.println("Action: Bold text");
        });
        add(boldTextButton);
        
        JButton italicTextButton = ButtonFactory.createIconButton("/icons/text_italic.png", e -> {
        	System.out.println("Action: Italic text");
        });
        add(italicTextButton);

        addSeparator();
        
        /* Editor controls */
        
        JButton switchEditorView = ButtonFactory.createIconButton("/icons/page_white_code.png", e -> {
        	System.out.println("Action: Switch editor view");
        });
        add(switchEditorView);
        
        JButton zoomInButton = ButtonFactory.createIconButton("/icons/magnifier_zoom_in.png", e -> {
        	System.out.println("Action: Zoom in");
        });
        add(zoomInButton);
        
        JButton zoomOutButton = ButtonFactory.createIconButton("/icons/magnifier_zoom_out.png", e -> {
        	System.out.println("Action: Zoom out");
        });
        add(zoomOutButton);

        addSeparator();
        
        /* Move note, rename note, search in note, export to PDF */
        
        JButton moveNoteButton = ButtonFactory.createIconButton("/icons/folder_go.png", e -> {
        	System.out.println("Action: Move note");
        });
        add(moveNoteButton);
        
        JButton renameNoteButton = ButtonFactory.createIconButton("/icons/page_edit.png", e -> {
        	System.out.println("Action: Rename note");
        });
        add(renameNoteButton);
        
        JButton searchInNoteButton = ButtonFactory.createIconButton("/icons/page_white_magnify.png", e -> {
        	System.out.println("Action: Search in note");
        });
        add(searchInNoteButton);
        
        JButton exportToPDFButton = ButtonFactory.createIconButton("/icons/page_white_acrobat.png", e -> {
        	System.out.println("Action: Export to PDF");
        });
        add(exportToPDFButton);

        addSeparator();
    }

    private void configureSearchField() {
        JTextField searchText = new JTextField();
        searchText.setPreferredSize(new Dimension(150, 22));
        searchText.setMaximumSize(new Dimension(150, 22));

        add(searchText);
    }
}
