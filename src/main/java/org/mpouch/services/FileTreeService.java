package org.mpouch.services;

import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;

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

        if (file.isDirectory()) {
            File[] children = file.listFiles();

            if (children != null) {
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
