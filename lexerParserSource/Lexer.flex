/*
  This example comes from a short article series in the Linux 
  Gazette by Richard A. Sevenich and Christopher Lopes, titled
  "Compiler Construction Tools". The article series starts at

  http://www.linuxgazette.com/issue39/sevenich.html

  Small changes and updates to newest JFlex+Cup versions 
  by Gerwin Klein
*/

/*
  Commented By: Christopher Lopes
  File Name: lcalc.flex
  To Create: > jflex lcalc.flex

  and then after the parser is created
  > javac Lexer.java
*/
   
/* --------------------------Usercode Section------------------------ */
   
import java_cup.runtime.*;
      
%%
   
/* -----------------Options and Declarations Section----------------- */
   
/* 
   The name of the class JFlex will create will be Lexer.
   Will write the code to the file Lexer.java. 
*/
%class Lexer

/*
  The current line number can be accessed with the variable yyline
  and the current column number with the variable yycolumn.
*/
%line
%column
    
/* 
   Will switch to a CUP compatibility mode to interface with a CUP
   generated parser.
*/
%cup
   
/*
  Declarations
   
  Code between %{ and %}, both of which must be at the beginning of a
  line, will be copied letter to letter into the lexer class source.
  Here you declare member variables and functions that are used inside
  scanner actions.  
*/
%{   
    /* To create a new java_cup.runtime.Symbol with information about
       the current token, the token will have no value in this
       case. */
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    
    /* Also creates a new java_cup.runtime.Symbol with information
       about the current token, but this object has a value. */
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}
   

/*
  Macro Declarations
  
  These declarations are regular expressions that will be used latter
  in the Lexical Rules Section.  
*/
   
/* A line terminator is a \r (carriage return), \n (line feed), or
   \r\n. */
LineTerminator = \r|\n|\r\n
   
/* White space is a line terminator, space, tab, or line feed. */
WhiteSpace     = {LineTerminator} | [ \t\f]
   
/* A literal integer is is a number beginning with a number between
   one and nine followed by zero or more numbers between zero and nine
   or just a zero.  */
numero = 0 | [1-9][0-9]*
texto = [A-Za-z_][A-Za-z_0-9]*
   
%%
/* ------------------------Lexical Rules Section---------------------- */
   
/*
   This section contains regular expressions and actions, i.e. Java
   code, that will be executed when the scanner matches the associated
   regular expression. */
   
   /* YYINITIAL is the state at which the lexer begins scanning.  So
   these regular expressions will only be matched if the scanner is in
   the start state YYINITIAL. */
   
<YYINITIAL> {
   
    "DAME"                { return symbol(sym.SELECT); }
    "Y"                { return symbol(sym.AND); }
    "DE"                { return symbol(sym.OF); }
    "CON"                { return symbol(sym.WITH); }
    "MAYOR"                { return symbol(sym.GREATER); }
    "IGUAL"                { return symbol(sym.EQUAL); }
    "MENOR"                { return symbol(sym.LOWER); }
    "A"                { return symbol(sym.THANTOCONN); }
    "INCLUYENDO"                { return symbol(sym.INCLUDING); }

    ";"                { return symbol(sym.SEMI); }

    "nombre"                { return symbol(sym.CATNAME); }
    "continente"                { return symbol(sym.CATCOUNTRY); }
    "población"                { return symbol(sym.CATPOP); }
    "idiomas"                { return symbol(sym.CATLANGS); }
    "zona_horaria"                { return symbol(sym.CATTZ); }
    "gobierno"                { return symbol(sym.CATGOV); }
    "superficie"                { return symbol(sym.CATSIZE); }
    "*"                { return symbol(sym.EVERYCAT); }
    "todo"                { return symbol(sym.EVERYCAT); }

    "PAISES"                { return symbol(sym.COUNTRIESDB); }
   
    /* If an integer is found print it out, return the token NUMBER
       that represents an integer and the value of the integer that is
       held in the string yytext which will get turned into an integer
       before returning */
    {numero}      { return symbol(sym.NUMBER, Integer.valueOf(yytext())); }
    {texto}      { System.out.print(yytext());
                         return symbol(sym.TEXT, yytext()); }
   
    /* Don't do anything if whitespace is found */
    {WhiteSpace}       { /* just skip what was found, do nothing */ }   
}


/* No token was found for the input so through an error.  Print out an
   Illegal character message with the illegal character that was found. */
[^]                    { throw new Error("Illegal character <"+yytext()+">"); }
