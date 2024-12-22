package org.mpouch.services;

import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;

public class FileTreeService {

    public DefaultMutableTreeNode buildFileTree(String path) {
        File rootFile = new File(path);

        if (!rootFile.exists() || !rootFile.isDirectory()) {
            throw new IllegalArgumentException("Invalid directory");
        }

        return createNode(rootFile);
    }

    public DefaultMutableTreeNode createNode(File file) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(file);
        node.setUserObject(file);

        if (file.isDirectory()) {
            File[] children = file.listFiles();

            if (children != null) {
                for (File child : children) {
                    node.add(createNode(child));
                }
            }
        }

        return node;
    }
}
