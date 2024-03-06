package edu.robertob.p1compi1.Frames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TreeFileContextMenu extends JPopupMenu {
    public TreeFileContextMenu(MainPanel mainPanel) {

        JMenuItem delete = new JMenuItem("Eliminar este archivo...");
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Delete child");
                mainPanel.deleteSelectedFile();
            }
        });

        add(delete);
    }
}
