package org.mpouch.ui.components;

import org.mpouch.controllers.SaveController;
import org.mpouch.ui.MainFrame;
import org.mpouch.ui.factories.ButtonFactory;
import org.mpouch.ui.panels.CenterPanel;

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
        add(createButton("/icons/arrow_left.png"));
        add(createButton("/icons/arrow_right.png"));
        add(createButton("/icons/house.png"));
        add(createButton("/icons/arrow_up.png"));

        addSeparator();

        add(createButton("/icons/add.png"));
        add(createButton("/icons/delete.png"));

        JButton saveButton = ButtonFactory.createButton("/icons/disk.png", e-> {
            SaveController saveController = new SaveController();
            saveController.saveNote();
        });

        add(saveButton);

        addSeparator();

        add(createButton("/icons/magnifier.png"));
        add(createButton("/icons/page_white_go.png"));
        add(createButton("/icons/folder_star.png"));

        addSeparator();

        add(createButton("/icons/link.png"));
        add(createButton("/icons/text_bold.png"));
        add(createButton("/icons/text_italic.png"));

        addSeparator();

        add(createButton("/icons/page_white_code.png"));
        add(createButton("/icons/magnifier_zoom_in.png"));
        add(createButton("/icons/magnifier_zoom_out.png"));

        addSeparator();

        add(createButton("/icons/folder_go.png"));
        add(createButton("/icons/page_edit.png"));
        add(createButton("/icons/page_white_magnify.png"));
        add(createButton("/icons/page_white_acrobat.png"));

        addSeparator();
    }

    public void configureSearchField() {
        JTextField searchText = new JTextField();
        searchText.setPreferredSize(new Dimension(150, 22));
        searchText.setMaximumSize(new Dimension(150, 22));

        add(searchText);
    }

    private JButton createButton(String path) {
        return new JButton(new ImageIcon(getClass().getResource(path)));
    }
}
