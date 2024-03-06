/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.robertob.p1compi1.Models;

public class FileItem extends ProjectItem {
    private String location;

    private DirectoryItem parent;

    public FileItem(String name, String location) {
        super(name);
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
