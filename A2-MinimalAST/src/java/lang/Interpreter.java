package lang;
import lang.ast.Program;
import lang.ast.ErrorMessage;
import java.io.File;
import lang.Compiler;

public class Interpreter {
    public static void main(String args[]) {
        Program program;
        try {
            program = Compiler.compile(new File(args[0]));
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
        program.eval();
    }
}
