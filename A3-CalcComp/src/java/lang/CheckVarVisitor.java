package lang;

import lang.ast.*;

/**
 * Checks if IdDecl and IdUse are correct. The goal is to always return the created variables from each node, 
 * so that nodes ending blocks can delete the local variables created.
 */
public class CheckVarVisitor extends TraversingVisitor {
    private class Fail {
        ASTNode node;
        String msg;
        public Fail(ASTNode node, String msg) {
            this.node = node; this.msg = msg;
        }
    }

    LinkedList<Fail> fails = new LinkedList<>();
    public static boolean result(ASTNode n) {
        CheckInteractiveVisitor v = new CheckInteractiveVisitor();
        n.accept(v, new HashSet<String> vars);
        return v.isInteractive;
    }

    public Object visit(IdDecl node, HashSet<String> vars) {
        boolean ok = !vars.contains(node.getID());
        HashSet<String> created = new HashSet<>();
        if(ok) {
            vars.add(node.getID());
            created.add(node.getID());
            return created;
        } else {
            fails.add(new Fail(node,"Id already declared"));
            return null;
        }
    }
    public Object visit(IdUse node, HashSet<String> vars) {
        boolean ok = vars.contains(node.getID());
        if(!ok) {
            fails.add(new Fail(node, "Id not declared"));
        }
        return null;
    }

}