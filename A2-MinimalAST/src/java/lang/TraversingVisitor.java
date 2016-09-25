package lang;

import lang.ast.*;

/**
 * Traverses each node, passing the data to the children.
 * Returns the data unchanged.
 * Overriding methods may change the data passed and the data returned.
 */
public abstract class TraversingVisitor implements lang.ast.Visitor {

	protected  Object visitChildren(ASTNode node, Object data) {
		for (int i = 0; i < node.getNumChild(); ++i) {
			node.getChild(i).accept(this, data);
		}
		return data;
	}
	//Special
	public Object visit(Program node, Object data) {
		return visitChildren(node, data);
	}

	public Object visit(List node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Opt node, Object data) {
		return visitChildren(node, data);
	}

	public Object visit(IdDecl node, Object data) {
		return visitChildren(node, data);
	}

	public Object visit(Function node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Block node, Object data) {
		return visitChildren(node, data);
	}

	//Stmts
	public Object visit(IfStmt node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(ElseBlock node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(IfBlock node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(WhileStmt node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(ForStmt node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Assign node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(IdStmt node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Return node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(ExpressionStmt node, Object data) {
		return visitChildren(node, data);
	}



	//Expr
	public Object visit(Literal node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(IdUse node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(FunctionCall node, Object data) {
		return visitChildren(node, data);
	}
	//BinExpr
	public Object visit(Add node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Sub node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Mul node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Mod node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(LessThan node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(GreaterThan node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(LessThanEq node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(GreaterThanEq node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(NotEq node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Equals node, Object data) {
		return visitChildren(node, data);
	}

}
