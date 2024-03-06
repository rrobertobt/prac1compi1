/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.robertob.p1compi1.Models;

import java.util.List;

public class DirectoryItem extends ProjectItem {
    private List<ProjectItem> content;

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
    
}
