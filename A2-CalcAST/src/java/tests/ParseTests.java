package tests;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class ParseTests extends AbstractTestSuite {
	public ParseTests() {
		super("testfiles/parser");// where test input files are
	}

	@Test
	public void identifier() {
		testValidSyntax("identifier.calc");
	}

	@Test
	public void let() {
		testValidSyntax("let.calc");
	}

	@Test
	public void numerical() {
		testValidSyntax("numerical.calc");
	}

	@Test
	public void product() {
		testValidSyntax("product.calc");
	}

	@Test
	public void error() {
		testSyntaxError("error.calc");
	}

	@Test
	public void error2() {
		testSyntaxError("error2.calc");
	}

	@Test
	public void error3() {
		testSyntaxError("error3.calc");
	}
}
