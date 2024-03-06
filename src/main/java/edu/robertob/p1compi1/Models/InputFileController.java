package edu.robertob.p1compi1.Models;

import edu.robertob.p1compi1.InputFileHandle.InputFileLexer;
import edu.robertob.p1compi1.InputFileHandle.InputFileParser;
import edu.robertob.p1compi1.Utils.ProjectUtils;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.StringReader;
import java.util.List;

public class InputFileController {
    private InputFileLexer lexer;
    private InputFileParser parser;
    InputFileHandler inputFileHandler;

    private DefaultMutableTreeNode projectTreeRoot;

    public InputFileController() {
        this.lexer = new InputFileLexer(null);
        this.parser = new InputFileParser(lexer);
        this.inputFileHandler = new InputFileHandler();
    }

    public Project parseInputFile() {
        try {
            String fileContent = inputFileHandler.createIdeFileChooser();
//            System.out.println("File content: " + fileContent);
            if (fileContent == null || fileContent.isEmpty()) {
                return null;
            }
            lexer = new InputFileLexer(new StringReader(fileContent));
            parser = new InputFileParser(lexer);

            Project parseResult = (Project)parser.parse().value;
            parseResult.setFileFullPath(inputFileHandler.fileFullPath);
//            ProjectUtils.printProject(parseResult.getContent().getContent(), 0);
            var tree = ProjectUtils.getProjectTree(parseResult.getContent().getContent(), parseResult);

            List<String> errors = parser.getErrors();
            if (errors.size() > 0) {
                JOptionPane.showMessageDialog(null, "Errores en el archivo de entrada:\n" + errors);
                return null;
            }
            this.projectTreeRoot = tree;
            System.out.println("Tree: " + tree);
            return parseResult;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    public DefaultMutableTreeNode getProjectTreeRoot() {
        return projectTreeRoot;
    }
}
