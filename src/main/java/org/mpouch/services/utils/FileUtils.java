package org.mpouch.services.utils;

import java.io.File;

public class FileUtils {

    /**
     * Hides markdown extension
     */
    public static String getCleanFileName(File file) {
        if (file.getName().endsWith(".md")) {
            return file.getName().substring(0, file.getName().length() - 3);
        }
        return file.getName();
    }
}
