package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import lang.ast.Program;
import lang.ast.Program;
import lang.TraversingVisitor;

/**
 * Tests MSNVisitor
 */
@RunWith(Parameterized.class)
public class TestNameAnalysis extends AbstractParameterizedTest {
	/**
	 * Directory where test files live
	 */
	private static final String TEST_DIR = "testfiles/nameanalysis";

	/**
	 * Construct a new JastAdd test
	 * @param testFile filename of test input file
	 */
	public TestNameAnalysis(String testFile) {
		super(TEST_DIR, testFile);
	}

	/**
	 * Run the JastAdd test
	 */
	@Test
	public void runTest() throws Exception {
		Program program = (Program) parse(inFile);

        ByteArrayOutputStream byos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byos);
        program.checkNames(ps);
		compareOutput(byos.toString(), outFile, expectedFile);
	}

	@SuppressWarnings("javadoc")
	@Parameters(name = "{0}")
	public static Iterable<Object[]> getTests() {
		return getTestParameters(TEST_DIR);
	}
}
