package lang;
import lang.ast.Program;
import lang.ast.Function;
import lang.ast.ErrorMessage;
import java.util.Set;
import java.io.File;
import lang.Compiler;

public class CallGraph {
    public static void main(String args[]) {
        Program program;
        File file = new File(args[0]);
        try {
            program = Compiler.compile(file);
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        for(Function func : program.getFunctionList()) {
            System.out.println("Current function: " + func.getIdDecl().getID());
            Set<Function> s = func.functionCalls();
            for(Function calledFunc : s) {
                System.out.println("    " + calledFunc.getIdDecl().getID());
            }
        }

    }
}
