package org.mpouch.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveService {
    public void saveToFile(String content, File file) throws IOException {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
        }
        
        System.out.println("Saved: " + file);
        
    }
}
