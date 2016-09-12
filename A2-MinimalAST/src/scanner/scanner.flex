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
ID = [a-zA-Z]+
TYPE = "int" | "double" | "float"
LITERAL = [0-9]+ ("." [0-9]+)? | "\"" [a-zA-Z]* "\""

%%

// discard whitespace information
{WhiteSpace}  { }

// token definitions
{TYPE}         { return sym(Terminals.TYPE); }
"("           { return sym(Terminals.LEFTP); }
")"           { return sym(Terminals.RIGHTP); }
"{"           { return sym(Terminals.LEFTB); }
"}"           { return sym(Terminals.RIGHTB); }
";"			  { return sym(Terminals.SEMIC); }
"="			  { return sym(Terminals.EQ); }
"*"           { return sym(Terminals.MUL); }
"+"           { return sym(Terminals.PLUS); }
"%"           { return sym(Terminals.MOD); }
"-"           { return sym(Terminals.MINUS); }

{LITERAL}	  { return sym(Terminals.LITERAL); }
{ID}          { return sym(Terminals.ID); }
<<EOF>>       { return sym(Terminals.EOF); }

/* error fallback */
[^]           { throw new SyntaxError("Illegal character <"+yytext()+">"); }
