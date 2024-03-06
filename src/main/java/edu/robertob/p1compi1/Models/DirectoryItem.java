/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.robertob.p1compi1.Models;

import javax.swing.*;
import java.util.List;

public class DirectoryItem extends ProjectItem {
    private List<ProjectItem> content;
    private DirectoryItem parent;

    public DirectoryItem(String name, List<ProjectItem> content) {
        super(name);
        this.content = content;
    }

    public List<ProjectItem> getContent() {
        return content;
    }

    public void setContent(List<ProjectItem> content) {
        this.content = content;
    }

    // create method to add a directory to the content list and check if it already exists
    public boolean addDirectory (DirectoryItem directory) {
        for (ProjectItem projectItem : this.content) {
            if (projectItem instanceof DirectoryItem) {
                if (projectItem.getName().equals(directory.getName())) {
                    //show joptionpane with error message
                    JOptionPane.showMessageDialog(null, "El directorio ya existe", "Error", JOptionPane.ERROR_MESSAGE);

                    return false;
                }
            }
        }
        this.content.add(directory);
        return true;
    }

    public boolean addFile (FileItem file) {
        for (ProjectItem projectItem : this.content) {
            if (projectItem instanceof FileItem) {
                if (projectItem.getName().equals(file.getName())) {
                    //show joptionpane with error message
                    JOptionPane.showMessageDialog(null, "El archivo ya existe", "Error", JOptionPane.ERROR_MESSAGE);

                    return false;
                }
            }
        }
        this.content.add(file);
        return true;
    }


    public String toString() {
        return this.getName();
    }

    public DirectoryItem getParent() {
        return parent;
    }

    public void setParent(DirectoryItem parent) {
        this.parent = parent;
    }
}
