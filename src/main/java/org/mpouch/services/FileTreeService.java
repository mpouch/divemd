package org.mpouch.services;

import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class FileTreeService {

    public DefaultMutableTreeNode buildFileTree(String path) {
        File rootFile = new File(path);

        if (!rootFile.exists() || !rootFile.isDirectory()) {
            throw new IllegalArgumentException("Invalid directory: " + path);
        }

        return createNode(rootFile);
    }

    private DefaultMutableTreeNode createNode(File file) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(file);
        node.setUserObject(file);

        // Sort by file type (directory or markdown), then sort by file name
        Comparator<File> fileComparator = (n1, n2) -> {
            boolean isDirectory1 = n1.isDirectory();
            boolean isDirectory2 = n2.isDirectory();

            if (isDirectory1 && !isDirectory2) {
                return -1;
            } else if (!isDirectory1 && isDirectory2) {
                return 1;
            } else {
                return n1.getName().compareTo(n2.getName());
            }
        };

        if (file.isDirectory()) {
            File[] children = file.listFiles();

            if (children != null) {
                Arrays.sort(children, fileComparator);
                for (File child : children) {
                    if (child.isDirectory() || child.getName().endsWith(".md")) {
                        node.add(createNode(child));
                    }
                }
            }
        }

        return node;
    }
}
