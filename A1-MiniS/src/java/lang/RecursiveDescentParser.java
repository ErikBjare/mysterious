package lang;
import lang.RDPTemplate;
import lang.ast.LangScanner;
import static lang.ast.LangParser.Terminals.*;

public class RecursiveDescentParser extends RDPTemplate {
    /**
     * Entry hook to start parsing.
     * @throws RuntimeException if the program is not syntactically correct
     */
    public void parseProgram() {
        statement();
    }


    public void statement() {
        int token = peek();

        switch(token) {
            case ID:
                assignStmt();
                break;
            case IF:
                ifStmt();
                break;
            case FOR:
                forStmt();
                break;
            default:
                error("Unexpected token: " + NAMES[token]);
                break;
        }
    }

    public void forStmt() {
        accept(FOR);
        assignStmt();
        accept(UNTIL);
        expression();
        accept(DO);
        statement();
        accept(OD);
    }

    public void ifStmt() {
        accept(IF);
        expression();
        accept(THEN);
        statement();
        accept(FI);
    }

    public void assignStmt() {
        accept(ID);
        accept(EQ);
        expression();
    }

    public void expression() {
        int token = peek();

        switch(token) {
            case ID:
                accept(ID);
                break;
            case NUMERAL:
                accept(NUMERAL);
                break;
            case NOT:
                accept(NOT);
                expression();
                break;
            default:
                error("Unexpected token: " + token);
                break;
        }
    }
}
