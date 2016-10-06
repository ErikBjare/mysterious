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

        StringBuilder sb = new StringBuilder();
        sb.append("digraph G {\n");
        for(Function func : program.getFunctionList()) {
            String from = func.getIdDecl().getID();
            Set<Function> s = func.functionCalls();
            for(Function calledFunc : s) {
                String to = calledFunc.getIdDecl().getID();
                sb.append("    " + from + " -> " + to + ";\n");
            }
            for(Function reachableFunc : func.reachableFunctions()) {
                if(!s.contains(reachableFunc)) {
                    sb.append("    " + from + " -> " + reachableFunc.getIdDecl().getID() + " [style=dotted];\n");
                }
            }
        }
        sb.append("}");


        System.out.println(sb);

    }
}
