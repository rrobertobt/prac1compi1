package edu.robertob.p1compi1.Models;

import java.util.ArrayList;
import java.util.List;


public class Project {
    private String name;
//    private List<ProjectItem> content;
    private DirectoryItem rootContent = new DirectoryItem("root", new ArrayList<>());

    public Project(String name) {
        this.name = name;
        this.rootContent.setContent(new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    public void addFile(String fileName, String location) {
        rootContent.getContent().add(new FileItem(fileName, location));
    }

    public void addFolder(String folderName) {
        rootContent.getContent().add(new DirectoryItem(folderName, new ArrayList<>()));
    }

    public void addFileOrFolder(String[] path, String fileName, String location) {
        addFileOrFolderRecursive(rootContent.getContent(), path, fileName, location);
    }

    private void addFileOrFolderRecursive(List<ProjectItem> items, String[] path, String fileName, String location) {
        if (path.length == 0) {
            items.add(new FileItem(fileName, location));
            return;
        }

        String nextFolderName = path[0];
        for (ProjectItem item : items) {
            if (item instanceof DirectoryItem && item.getName().equals(nextFolderName)) {
                DirectoryItem directory = (DirectoryItem) item;
                String[] newPath = new String[path.length - 1];
                System.arraycopy(path, 1, newPath, 0, path.length - 1);
                addFileOrFolderRecursive(directory.getContent(), newPath, fileName, location);
                return;
            }
        }

        // If the folder does not exist, create it
        DirectoryItem newDirectory = new DirectoryItem(nextFolderName, new ArrayList<>());
        items.add(newDirectory);
        String[] newPath = new String[path.length - 1];
        System.arraycopy(path, 1, newPath, 0, path.length - 1);
        addFileOrFolderRecursive(newDirectory.getContent(), newPath, fileName, location);
    }

    public DirectoryItem getContent() {
        return rootContent;
    }
}
