package lang;
import lang.ast.LangParser;
import lang.ast.LangScanner;
import static lang.ast.LangParser.Terminals.*;

/**
 * Abstract base class for recursive decent parsers. The class provides convenience methods
 * to integrate a scanner, like peeking the next token or reading a certain token. Subclasses
 * must implement the parseProgram() method, which is used as entry point for recursive decent
 * parsing.
 */
public abstract class RDPTemplate {
    private LangScanner scanner;
    private beaver.Symbol currentToken;

    /**
     * Initialize the parser and start parsing via the parseProgram() method.
     * @param scanner providing the token stream to process; used throughout parsing
     * @throws RuntimeException if the program is not syntactically correct
     */
    public void parse(LangScanner scanner) {
        this.scanner = scanner;
        parseProgram();
        accept(EOF); // Ensure all input is processed.
    }

    /**
     * Entry hook to start parsing.
     * @throws RuntimeException if the program is not syntactically correct
     */
    public abstract void parseProgram();

    /**
     * Peek the current token, i.e., return it without proceeding to the next token.
     * @return ID of the current token
     */
    public int peek() {
        if (currentToken == null) accept();
        return currentToken.getId();
    }

    /**
     * Test the current token without proceeding to the next.
     * @param expectedToken token type to test for
     * @return true, if the current token is of the expected type, otherwise false.
     */
    public boolean peek(int expectedToken) {
        return peek() == expectedToken;
    }

    /**
     * Read the next token (invokes the scanner to set the current token to the next).
     */
    public void accept() {
        try {
            currentToken = scanner.nextToken();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Ensure the current token is of a certain type; then read the next.
     * @param expectedToken token type to test for
     * @throws RuntimeException if the current token is not of the expected type
     */
    public void accept(int expectedToken) {
        if (!peek(expectedToken)) {
            error("expected token " +
                    LangParser.Terminals.NAMES[expectedToken] +
                    " got token " +
                    LangParser.Terminals.NAMES[currentToken.getId()]);
        }
        accept();
    }

    /**
     * Throw runtime exception with the given message.
     * @param message of the thrown exception
     * @throws RuntimeException always thrown
     */
    public void error(String message) {
        throw new RuntimeException(message);
    }
}
