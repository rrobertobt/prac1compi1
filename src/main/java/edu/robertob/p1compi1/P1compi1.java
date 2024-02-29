/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.robertob.p1compi1;

import edu.robertob.p1compi1.Lexer.InputFileLexer;
import edu.robertob.p1compi1.Lexer.Token;

/**
 *
 * @author robertob
 */
public class P1compi1 {

    public static void main(String[] args) {
        InputFileLexer testLexer = new InputFileLexer();
//        testLexer.setTestString("<PROYECTO nombre=\"proy-name\">");
        testLexer.setTestString("<PROYECTO nombre=\"proy-name\">\n" +
                "\t<ARCHIVO nombre=\"nombre\" ubicacion=\"/home/yo/docs/miarchivo.csv\"/>\n" +
                "\t<CARPETA nombre=\"CARPETA\">\n" +
                "\t<ARCHIVO nombre=\"nombre1\" ubicacion=\"/home/yo/docs/miarchivo1.csv\"/>\n" +
                "\t<ARCHIVO nombre=\"nombre2\" ubicacion=\"/home/yo/docs/miarchivo2.csv\"/>\n" +
                "\t</CARPETA>\n" +
                "</PROYECTO>");
        while (!testLexer.yyatEOF()){
            try {
                Token currentToken = testLexer.yylex();
                String lexeme = testLexer.getCurrentLexeme();
                System.out.println("Token: " + currentToken + " Lexeme: " + lexeme);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
