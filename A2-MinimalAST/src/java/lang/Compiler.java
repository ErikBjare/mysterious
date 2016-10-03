package lang;


import lang.ast.ErrorMessage;
import lang.ast.Program;
import lang.ast.LangParser;
import lang.ast.LangScanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.RuntimeException;

public class Compiler {

	public static Program compile(File inFile) throws Exception {
		LangScanner scanner = new LangScanner(new FileReader(inFile));
		LangParser parser = new LangParser();
		Program program = (Program) parser.parse(scanner);
		StringBuilder sb = new StringBuilder();
		for (ErrorMessage m: program.errors()) {
			sb.append(m).append("\n");
		}
		if(sb.length() != 0) {
			throw new RuntimeException(sb.toString());
		}
		return program;
	}
}
