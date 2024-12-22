package org.mpouch.controllers;

import org.mpouch.services.FileTreeService;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class FileTreeController {
    private final FileTreeService fileTreeService;

    public FileTreeController() {
        this.fileTreeService = new FileTreeService();
    }

    public DefaultTreeModel getTreeModel(String path) {
        DefaultMutableTreeNode rootNode = fileTreeService.buildFileTree(path);
        return new DefaultTreeModel(rootNode);
    }
}
