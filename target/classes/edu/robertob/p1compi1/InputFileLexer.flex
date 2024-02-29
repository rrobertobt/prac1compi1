package edu.robertob.p1compi1.Lexer;

//import java_cup.runtime.Symbol;
import edu.robertob.p1compi1.Lexer.Token;
import java.io.StringReader;
%%


%class InputFileLexer
%public
%line
%column
%eofval{
    return Token.EOF;
%eofval}
%type Token

// Regular Definitions

%{
private String currentLexeme;

    public String getCurrentLexeme() {
        return currentLexeme;
    }

    public InputFileLexer() {
    }

    public void setTestString(String testString) {
        this.zzReader = new StringReader(testString);
    }
%}

digit = [0-9]
letter = [a-zA-Z]
whitespace = [\t\n\r ]
non_quote = [^\"]

// Regular Expressions
%%
// Rules
"<"                     { currentLexeme = yytext(); return Token.TAG_OPEN;}
">"                     { currentLexeme = yytext(); return Token.TAG_CLOSE;}
"/>"                    { currentLexeme = yytext(); return Token.TAG_SELF_CLOSE;}
"</"                    { currentLexeme = yytext(); return Token.TAG_CLOSE_REVERSE;}
"="                     { currentLexeme = yytext(); return Token.EQUALS;}
"\""                    { currentLexeme = yytext(); return Token.QUOTE;}
"PROYECTO"              { currentLexeme = yytext(); return Token.TAG_NAME_PROJECT;}
"ARCHIVO"               { currentLexeme = yytext(); return Token.TAG_NAME_FILE;}
"CARPETA"               { currentLexeme = yytext(); return Token.TAG_NAME_FOLDER;}
"nombre"                { currentLexeme = yytext(); return Token.TAG_ATTRIBUTE_NAME;}
"ubicacion"             { currentLexeme = yytext(); return Token.TAG_ATTRIBUTE_LOCATION;}
{letter}({letter}|{digit}|-)* { currentLexeme = yytext(); return Token.TAG_ATTRIBUTE_VALUE;}
"/"({letter}|{digit}|[./])+ { currentLexeme = yytext(); return Token.TAG_ATTRIBUTE_VALUE;}

// Ignore whitespaces
{whitespace}+             {}

.                         {currentLexeme = yytext(); return Token.ILLEGAL; }
