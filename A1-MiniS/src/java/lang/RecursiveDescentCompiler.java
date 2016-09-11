package lang;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import lang.ast.LangParser;
import lang.ast.LangParser.SyntaxError;
import lang.ast.LangScanner;

public class RecursiveDescentCompiler extends Compiler {
	private static void parse(Reader reader) {
		LangScanner scanner = new LangScanner(reader);
		RecursiveDescentParser parser = new RecursiveDescentParser();

		try {
			parser.parse(scanner);
			System.out.println("Valid syntax");
		} catch (RuntimeException e) {
			System.err.println("Syntax error: " + e.getMessage());
		}
       /* catch (IOException e) {
			e.printStackTrace();
		}*/
	}
}
