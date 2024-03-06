package edu.robertob.p1compi1;

import edu.robertob.p1compi1.InputFileHandle.InputFileLexer;
import edu.robertob.p1compi1.InputFileHandle.InputFileParser;
import edu.robertob.p1compi1.Frames.MainFrame;
import edu.robertob.p1compi1.Models.DirectoryItem;
import edu.robertob.p1compi1.Models.FileItem;
import edu.robertob.p1compi1.Models.Project;
import edu.robertob.p1compi1.Models.ProjectItem;

import java.io.StringReader;
import java.util.List;

public class P1compi1 {

    public static void main(String[] args) {

//        Project project = new Project("MyProject");

        // Add files and folders to the project
//        project.addFile("File1", "/path/to/File1.csv");
//        project.addFolder("Folder1");
//        project.addFileOrFolder(new String[]{"Folder1", "Folder2"}, "File2", "/path/to/File2.csv");
//        project.addFileOrFolder(new String[]{"Folder1", "Folder2"}, "File3", "/path/to/File3.csv");
//        project.addFolder("Folder3");
//        project.addFileOrFolder(new String[]{"Folder1", "Folder2", "Folder4"}, "File4", "/path/to/File4.csv");

        // Print the project structure

//        MainFrame mainFrame = new MainFrame();
//        mainFrame.setVisible(true);
        StringReader reader = new StringReader(
                """
                <PROYECTO nombre="proy-name">
                \t<ARCHIVO nombre="nombre0" ubicacion="/home/yo/docs/miarchivo.csv"/>
                \t<CARPETA nombre="CARPETA">
                        \t<CARPETA nombre="CARPETA">
                            \t<CARPETA nombre="CARPETA">
                                \t<ARCHIVO nombre="nombre1" ubicacion="/home/yo/docs/miarchivo1.csv"/>
                            \t</CARPETA>
                            \t<ARCHIVO nombre="nombre1" ubicacion="/home/yo/docs/miarchivo1.csv"/>
                        \t</CARPETA>
                    \t<ARCHIVO nombre="nombre1" ubicacion="/home/yo/docs/miarchivo1.csv"/>
                    \t<ARCHIVO nombre="nombre2" ubicacion="/home/yo/docs/miarchivo2.csv"/>
                \t</CARPETA>
                </PROYECTO>""");
        InputFileLexer lexer = new InputFileLexer(reader);
        InputFileParser parser = new InputFileParser(lexer);

        try {
            Project project = (Project)parser.parse().value;
            System.out.println("Project name: " + project.getName());
            printProject(project.getContent().getContent(), 0);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void printProject(List<ProjectItem> items, int depth) {
        for (ProjectItem item : items) {
            if (item instanceof FileItem) {
                printIndent(depth);
                System.out.println("- " + item.getName());
            } else if (item instanceof DirectoryItem) {
                printIndent(depth);
                System.out.println("> " + item.getName());
                printProject(((DirectoryItem) item).getContent(), depth + 1);
            }
        }
    }

    private static void printIndent(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("   ");
        }
    }
}
