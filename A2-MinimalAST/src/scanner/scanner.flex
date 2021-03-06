package lang.ast; // The generated scanner will belong to the package lang.ast

import lang.ast.LangParser.Terminals; // The terminals are implicitly defined in the parser
import lang.ast.LangParser.SyntaxError;

%%

// define the signature for the generated scanner
%public
%final
%class LangScanner
%extends beaver.Scanner

// the interface between the scanner and the parser is the nextToken() method
%type beaver.Symbol
%function nextToken

// store line and column information in the tokens
%line
%column

// this code will be inlined in the body of the generated scanner class
%{
  private beaver.Symbol sym(short id) {
    return new beaver.Symbol(id, yyline + 1, yycolumn + 1, yylength(), yytext());
  }
%}

// macros
WhiteSpace = [ ] | \t | \f | \n | \r
ID = [a-zA-Z] [a-zA-Z0-9]*
TYPE = "int" | "double" | "float"
LITERAL = [0-9]+ ("." [0-9]+)? | "\"" [a-zA-Z]* "\""
COMMENT = "//" [^\n\r]*

%%

// discard whitespace information
{WhiteSpace}  { }
{COMMENT} { }

// token definitions
{TYPE}         { return sym(Terminals.TYPE); }
"("           { return sym(Terminals.LEFTP); }
")"           { return sym(Terminals.RIGHTP); }
"{"           { return sym(Terminals.LEFTB); }
"}"           { return sym(Terminals.RIGHTB); }
";"           { return sym(Terminals.SEMIC); }
"="          { return sym(Terminals.EQ); }
"=="          { return sym(Terminals.EQEQ); }
"!="          { return sym(Terminals.NOTEQ); }
"<"          { return sym(Terminals.LT); }
"<="          { return sym(Terminals.LTEQ); }
">"          { return sym(Terminals.GT); }
">="          { return sym(Terminals.GTEQ); }
"*"           { return sym(Terminals.MUL); }
"/"           { return sym(Terminals.DIV); }
"+"          { return sym(Terminals.PLUS); }
"%"         { return sym(Terminals.MOD); }
"-"           { return sym(Terminals.MINUS); }
","           { return sym(Terminals.COMMA); }
"while"    { return sym(Terminals.WHILE); }
"if"          { return sym(Terminals.IF); }
"else"     { return sym(Terminals.ELSE); }
"for"        { return sym(Terminals.FOR); }
"return"        { return sym(Terminals.RETURN); }

{LITERAL}	  { return sym(Terminals.LITERAL); }
{ID}          { return sym(Terminals.ID); }
<<EOF>>       { return sym(Terminals.EOF); }

/* error fallback */
[^]           { throw new SyntaxError("Illegal character <"+yytext()+">"); }
