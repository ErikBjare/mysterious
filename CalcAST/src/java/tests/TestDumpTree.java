package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import lang.ast.Program;

/**
 * Tests AST dumping
 * @author Jesper Öqvist <jesper.oqvist@cs.lth.se>
 */
@RunWith(Parameterized.class)
public class TestDumpTree extends AbstractParameterizedTest {
	/**
	 * Directory where test files live
	 */
	private static final String TEST_DIR = "testfiles/ast";

	/**
	 * Construct a new JastAdd test
	 * @param testFile filename of test input file
	 */
	public TestDumpTree(String testFile) {
		super(TEST_DIR, testFile);
	}

	/**
	 * Run the JastAdd test
	 */
	@Test
	public void runTest() throws Exception {
		Program program = (Program) parse(inFile);
		String actual = program.dumpTree();
		compareOutput(actual, outFile, expectedFile);
	}

	@SuppressWarnings("javadoc")
	@Parameters(name = "{0}")
	public static Iterable<Object[]> getTests() {
		return getTestParameters(TEST_DIR);
	}
}
