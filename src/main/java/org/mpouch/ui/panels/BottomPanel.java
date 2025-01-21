package org.mpouch.ui.panels;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class BottomPanel extends JPanel {
    private static final BottomPanel instance = new BottomPanel();
    private final JLabel backlinks = new JLabel("Backlinks: 0  "); // 0 is a placeholder
    private final JLabel words = new JLabel("Words:  ");
    private final JLabel characters = new JLabel("Characters:  ");
    private final JLabel createdDate = new JLabel("Created:  ");
    private final JLabel modifiedDate = new JLabel("Modified: ");

    public BottomPanel() {
        createBottomPanel();
    }

    public static BottomPanel getInstance() {
        return instance;
    }

    // Setters
    // TODO: backlinks

    private void setWordCount(int input) {
        words.setText("Words: " + input + "  ");
    }

    private void setCharacterCount(int input) {
        characters.setText("Characters: " + input + "  ");
    }

    private void setCreatedDate(String input) {
        createdDate.setText("Created: " + input + "  ");
    }

    private void setModifiedDate(String input) {
        modifiedDate.setText("Modified: " + input);
    }

    private void createBottomPanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        // setBackground(Color.decode("#E0ECF8"));

        add(backlinks);
        add(words);
        add(characters);
        add(createdDate);
        add(modifiedDate);
    }

    // TODO: backlinks
    // TODO: handle filesystems without timestamps on files
    public void updateFileAttributesDisplay(File file) throws IOException {
        Path filePath = file.toPath();
        String content = Files.readString(filePath);
        BasicFileAttributes attributes = Files.readAttributes(filePath, BasicFileAttributes.class);

        // Set labels
        setCharacterCount(getCharacterCount(content));
        setWordCount(getWordCount(content));
        setCreatedDate(getCreationTime(attributes));
        setModifiedDate(getModifiedTime(attributes));
    }

    private int getCharacterCount (String content) {
        return content.length();
    }

    private int getWordCount(String content) {
        int wordCount = 0;

        String[] words = content.split("\\s+");
        for (String word : words) {
            if (word.matches(".*[\\p{L}\\p{N}].*")) {
                wordCount ++;
            }
        }

        return wordCount;
    }

    // TODO: remove redundant code
    private String getCreationTime(BasicFileAttributes attributes) {
        FileTime creationTime = attributes.creationTime();
        ZonedDateTime localCreationTime = creationTime.toInstant().atZone(ZoneId.systemDefault());
        String[] creationTimeFormatted = localCreationTime.toString().split("[T.]");
        return creationTimeFormatted[0] + " " + creationTimeFormatted[1].substring(0, 5);
    }

    private String getModifiedTime(BasicFileAttributes attributes) {
        FileTime modifiedTime = attributes.lastModifiedTime();
        ZonedDateTime localModifiedTime = modifiedTime.toInstant().atZone(ZoneId.systemDefault());
        String[] modifiedTimeFormatted = localModifiedTime.toString().split("[T.]");
        return modifiedTimeFormatted[0] + " " + modifiedTimeFormatted[1].substring(0, 5);
    }
}
