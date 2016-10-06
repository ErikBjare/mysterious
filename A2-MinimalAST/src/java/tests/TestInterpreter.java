package tests;

import static org.junit.Assert.*;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import lang.ast.ErrorMessage;
import lang.ast.Program;
import lang.Compiler;

/**
 * Tests type analysis
 */
@RunWith(Parameterized.class)
public class TestInterpreter extends AbstractParameterizedTest {
	/**
	 * Directory where test files live
	 */
	private static final String TEST_DIR = "testfiles/interpreter";

	/**
	 * Construct a new JastAdd test
	 * @param filename filename of test input file
	 */
	public TestInterpreter(String filename) {
		super(TEST_DIR, filename);
	}

	/**
	 * Run the JastAdd test
	 */
	@Test
	public void runTest() throws Exception {
		Program program = (Program) parse(inFile);
		StringBuilder sb = new StringBuilder();
		for (ErrorMessage m: program.errors()) {
			sb.append(m).append("\n");
		}
        if(sb.length() != 0) {
            System.out.println(sb.toString());
            fail("Errors occurred during parsing");
        }

        PrintStream stdout = System.out;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream interpreterOut = new PrintStream(baos);

        System.setOut(interpreterOut);
        program.eval();
        System.setOut(stdout);

        compareOutput(baos.toString("UTF8"), outFile, expectedFile);
	}

	@SuppressWarnings("javadoc")
	@Parameters(name = "{0}")
	public static Iterable<Object[]> getTests() {
		return getTestParameters(TEST_DIR);
	}
}
