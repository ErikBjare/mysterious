package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import lang.ast.ErrorMessage;
import lang.ast.Program;

/**
 * Tests name analysis
 */
@RunWith(Parameterized.class)
public class TestNameAnalysis extends AbstractParameterizedTest {
	/**
	 * Directory where test files live
	 */
	private static final String TEST_DIR = "testfiles/nameanalysis";

	/**
	 * Construct a new JastAdd test
	 * @param filename filename of test input file
	 */
	public TestNameAnalysis(String filename) {
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
		compareOutput(sb.toString(), outFile, expectedFile);
	}

	@SuppressWarnings("javadoc")
	@Parameters(name = "{0}")
	public static Iterable<Object[]> getTests() {
		return getTestParameters(TEST_DIR);
	}
}
