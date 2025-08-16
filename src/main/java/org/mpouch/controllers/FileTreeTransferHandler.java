package org.mpouch.controllers;

import org.mpouch.ui.panels.SidePanel;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FileTreeTransferHandler extends TransferHandler {

    @Override
    protected Transferable createTransferable(JComponent component) {
        TreePath selectedNode = SidePanel.getInstance().getFileTree().getSelectionPath();

        if (selectedNode != null) {
            File selectedFile = (File) selectedNode.getLastPathComponent();

            if (selectedFile != null) {
                return new Transferable() {

                    @Override
                    public DataFlavor[] getTransferDataFlavors() {
                        return new DataFlavor[]{DataFlavor.javaFileListFlavor};
                    }

                    @Override
                    public boolean isDataFlavorSupported(DataFlavor flavor) {
                        return flavor.equals(DataFlavor.javaFileListFlavor);
                    }

                    @Override
                    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
                        if (flavor.equals(DataFlavor.javaFileListFlavor)) {

                            if (selectedFile.isDirectory()) {
                                return new ArrayList<>(
                                        Arrays.asList(Objects.requireNonNull(selectedFile.listFiles()))
                                );
                            } else if (selectedFile.getName().endsWith(".md")) {
                                return new ArrayList<>(List.of(selectedFile));
                            }
                        }
                        throw new UnsupportedFlavorException(flavor);
                    }
                };
            }
        }
        return null;
    }

    @Override
    public int getSourceActions(JComponent c) {
        return MOVE;
    }

    @Override
    public boolean canImport(TransferHandler.TransferSupport support) {
        if (!support.isDrop()) {
            return false;
        }
        return support.isDataFlavorSupported(DataFlavor.javaFileListFlavor);
    }
}
