package edu.robertob.p1compi1.Utils;

import edu.robertob.p1compi1.Models.DirectoryItem;
import edu.robertob.p1compi1.Models.FileItem;
import edu.robertob.p1compi1.Models.Project;
import edu.robertob.p1compi1.Models.ProjectItem;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProjectUtils {
    // this method is used to print the project tree in the console, in the custom format kind of serialization
    public static void printProject(Project project, List<ProjectItem> items, int depth) {
//        if (project != null) {
//            System.out.println("Project loaded from and saving to path: " + project.getFileFullPath());
//            printIndent(depth);
//            System.out.println("<PROYECTO nombre=\"" + project.getName() + "\">");
//        }
//        for (ProjectItem item : items) {
//            System.out.println("Item: " + item.getName());
//            if (item instanceof FileItem) {
//                printIndent(depth + 1);
//                System.out.println("<ARCHIVO nombre=\"" + item.getName() + "\" ubicacion=\"" + ((FileItem) item).getLocation() + "\"/>");
//            } else if (item instanceof DirectoryItem) {
//                DirectoryItem directory = (DirectoryItem) item;
//                printIndent(depth + 1);
//                System.out.println("<CARPETA nombre=\"" + directory.getName() + "\">");
//                printProject(null, directory.getContent(), depth + 2); // Recursive call for subdirectories
//                printIndent(depth + 1);
//                System.out.println("</CARPETA>");
//            }
//        }
//        if (project != null) {
//            printIndent(depth);
//            System.out.println("</PROYECTO>");
//        }

        String path = project.getFileFullPath();
        writeToFile(path, printProjectToString(project, items, 0));
    }

    public static void writeToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("File written successfully: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    public static DefaultMutableTreeNode getProjectTree(List<ProjectItem> items, Project project) {
//        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Raíz del proyecto");

//        DefaultMutableTreeNode root = new DefaultMutableTreeNode(new DirectoryItem("Raíz del proyecto", new ArrayList<>()));
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(project.getContent());
        for (ProjectItem item : items) {
            if (item instanceof FileItem) {
                // if it's a file then we havo save the location too in the tree node
//                root.add(new DefaultMutableTreeNode(item.getName()));
                root.add(new DefaultMutableTreeNode(item));
                System.out.println("File: " + item.getName());
            } else if (item instanceof DirectoryItem) {
                System.out.println("Directory: " + item.getName());
//                DefaultMutableTreeNode directoryNode = new DefaultMutableTreeNode(item.getName());
                DefaultMutableTreeNode directoryNode = new DefaultMutableTreeNode(item);
                root.add(directoryNode);
                getProjectTreeRecursive(((DirectoryItem) item).getContent(), directoryNode);
            }
        }
        return root;
    }

    private static void getProjectTreeRecursive(List<ProjectItem> items, DefaultMutableTreeNode parent) {
        for (ProjectItem item : items) {
            if (item instanceof FileItem) {
//                parent.add(new DefaultMutableTreeNode(item.getName()));
                parent.add(new DefaultMutableTreeNode(item));
            } else if (item instanceof DirectoryItem) {
//                DefaultMutableTreeNode directoryNode = new DefaultMutableTreeNode(item.getName());
                DefaultMutableTreeNode directoryNode = new DefaultMutableTreeNode(item);
                parent.add(directoryNode);
                getProjectTreeRecursive(((DirectoryItem) item).getContent(), directoryNode);
            }
        }
    }

    private static void printIndent(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("   ");
        }
    }

    public static String printProjectToString(Project project, List<ProjectItem> items, int depth) {
        StringBuilder sb = new StringBuilder();
        if (project != null) {
            sb.append(getIndent(depth)).append("<PROYECTO nombre=\"").append(project.getName()).append("\">\n");
        }
        for (ProjectItem item : items) {
            if (item instanceof FileItem) {
                sb.append(getIndent(depth + 1)).append("<ARCHIVO nombre=\"").append(item.getName())
                        .append("\" ubicacion=\"").append(((FileItem) item).getLocation()).append("\"/>\n");
            } else if (item instanceof DirectoryItem) {
                DirectoryItem directory = (DirectoryItem) item;
                sb.append(getIndent(depth + 1)).append("<CARPETA nombre=\"").append(directory.getName()).append("\">\n");
                sb.append(printProjectToString(null, directory.getContent(), depth + 2)); // Recursive call for subdirectories
                sb.append(getIndent(depth + 1)).append("</CARPETA>\n");
            }
        }
        if (project != null) {
            sb.append(getIndent(depth)).append("</PROYECTO>\n");
        }
        System.out.println("[WRITING THIS TO FILE: ]");
        System.out.println(sb.toString());
        return sb.toString();
    }

    private static String getIndent(int depth) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indent.append("    "); // Use appropriate indentation, like spaces or tabs
        }
        return indent.toString();
    }
}
