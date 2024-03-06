package edu.robertob.p1compi1.InputFileHandle;

import java_cup.runtime.*;
import java.io.StringReader;
%%


%class InputFileLexer
%public
%line
%column
%cup
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


%{

  private Symbol symbol(int type) {
    return new Symbol(type, yyline+1, yycolumn+1);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline+1, yycolumn+1, value);
  }
%}

// Regular Expressions
%%
// Rules with CUP
"<"                     { currentLexeme = yytext();
            
          return symbol(sym.TAG_OPEN); }

">"                     { currentLexeme = yytext();
            
          return symbol(sym.TAG_CLOSE);}

"/>"                    { currentLexeme = yytext();
            
          return symbol(sym.TAG_SELF_CLOSE);}

"</"                    { currentLexeme = yytext();
            
          return symbol(sym.TAG_CLOSE_REVERSE);}

"="                     { currentLexeme = yytext();
            
          return symbol(sym.EQUALS);}

//"\""                    { currentLexeme = yytext();
//            
//          return symbol(sym.QUOTE);}
//
//"”"                    { currentLexeme = yytext();
//            
//          return symbol(sym.QUOTE);}

"PROYECTO"              { currentLexeme = yytext();
            
          return symbol(sym.TAG_NAME_PROJECT);}

"ARCHIVO"               { currentLexeme = yytext();
            
          return symbol(sym.TAG_NAME_FILE);}

"CARPETA"               { currentLexeme = yytext();
            
          return symbol(sym.TAG_NAME_FOLDER);}

"nombre"                { currentLexeme = yytext();
            
          return symbol(sym.TAG_ATTRIBUTE_NAME);}

"ubicacion"             { currentLexeme = yytext();
            
          return symbol(sym.TAG_ATTRIBUTE_LOCATION);}

\"{letter}({letter}|{digit}|-)*\" { currentLexeme = yytext();
            
          return symbol(sym.TAG_ATTRIBUTE_VALUE, yytext());}

”{letter}({letter}|{digit}|-)*” { currentLexeme = yytext();
      
    return symbol(sym.TAG_ATTRIBUTE_VALUE, yytext());}

\""/"({letter}|{digit}|[./])+\" { currentLexeme = yytext();
            
          return symbol(sym.TAG_ATTRIBUTE_VALUE, yytext());}

”"/"({letter}|{digit}|[./])+” { currentLexeme = yytext();
            
          return symbol(sym.TAG_ATTRIBUTE_VALUE, yytext());}
// Ignore whitespaces
{whitespace}+             {}
.                         {currentLexeme = yytext(); return symbol(sym.ILLEGAL); }

