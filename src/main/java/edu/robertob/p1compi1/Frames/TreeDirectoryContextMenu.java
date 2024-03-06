package edu.robertob.p1compi1.Frames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TreeDirectoryContextMenu extends JPopupMenu {
    public TreeDirectoryContextMenu(MainPanel mainPanel) {

        JMenuItem add = new JMenuItem("Crear directorio aquí...");
        JMenuItem addFile = new JMenuItem("Crear archivo aquí...");
        JMenuItem delete = new JMenuItem("Eliminar directorio...");
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Add child");
                mainPanel.showAddDirectoryDialog();
            }
        });

        addFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Add file");
                mainPanel.showAddFileDialog();
            }
        });
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Delete child");
                mainPanel.deleteSelectedDirectory();
            }
        });
        add(add);
        add(addFile);
        add(delete);
    }
}
