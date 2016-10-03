package lang;
import lang.ast.Program;
import java.io.File;

public class Interpreter {
    public static void main(String args[]) {
        Program p;
        try {
            p = Compiler.compile(new File(args[0]));
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
        p.eval();
    }
}