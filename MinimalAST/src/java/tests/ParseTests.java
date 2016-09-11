package tests;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class ParseTests extends AbstractTestSuite {
	public ParseTests() {
		super("testfiles/parser");// where test input files are
	}

	@Test
	public void example() {
		testValidSyntax("example.lang");
	}

	@Test
	public void error() {
		testSyntaxError("error.lang");
	}
}
