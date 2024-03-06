/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.robertob.p1compi1.Models;

import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author robertob
 */
public class InputFileHandler {
    
    public String createIdeFileChooser () throws FileNotFoundException {
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.CANCEL_OPTION) return null;
        
        Scanner scanner = new Scanner(fileChooser.getSelectedFile());
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine());
        }
        scanner.close();
        System.out.println(sb.toString());
        return sb.toString();
    }
    
}
