package lang;
import lang.ast.*;
public class MSNVisitor extends TraversingVisitor{
    protected Object visitChildren(ASTNode node, Object deptho) {
        Integer maxdepth = (Integer)deptho;
        //System.out.println(maxdepth);
        for (int i = 0; i < node.getNumChild(); ++i) {
            maxdepth = Math.max((Integer)node.getChild(i).accept(this, deptho), maxdepth);
        }
        return maxdepth;
    }
    public Object visit(IfStmt node, Object data) {
        return visitChildren(node, (Integer) data + 1);
    }
    public Object visit(WhileStmt node, Object data) {
        return visitChildren(node, (Integer) data + 1);
    }
    public Object visit(ForStmt node, Object data) {
        return visitChildren(node, (Integer) data + 1);
    }
    public Object visit(Function node, Object data) {
        return visitChildren(node, (Integer) data + 1);
    }
}