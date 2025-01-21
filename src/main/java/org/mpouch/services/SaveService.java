package org.mpouch.services;

import org.mpouch.ui.panels.BottomPanel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveService {
    public void saveToFile(String content, File file) throws IOException {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
        }

        BottomPanel.getInstance().updateFileAttributesDisplay(file);
        System.out.println("Saved: " + file);
        
    }
}
