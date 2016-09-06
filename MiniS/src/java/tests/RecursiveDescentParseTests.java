package tests;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class RecursiveDescentParseTests extends AbstractTestSuite {
	public RecursiveDescentParseTests() {
        // Constructs with useRecursiveDescentParser = true;
		super("testfiles", true);// where test input files are
	}

    @Test
	public void full() {
		testValidSyntax("full.ms");
	}

	@Test
	public void error_scanner() {
		testSyntaxError("error_scanner.ms");
	}

    @Test
	public void error_parser() {
		testParsingError("error_parser.ms");
	}

	@Test
	public void shortest() {
		testValidSyntax("shortest.ms");
	}

    /**
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
	public void error2() {
		testSyntaxError("error2.calc");
	}

	@Test
	public void error3() {
		testSyntaxError("error3.calc");
	}

	@Test
	public void the_answer() {
		testValidSyntax("the_answer.calc");
	}
    */
}
