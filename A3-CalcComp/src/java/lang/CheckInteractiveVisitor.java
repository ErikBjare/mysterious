package lang;

import lang.ast.*;

/**
 * Checks if there are any 'ask user' statements in a Calc program.
 */
public class CheckInteractiveVisitor extends TraversingVisitor {
	// client method
	public static boolean result(ASTNode n) {
		CheckInteractiveVisitor v = new CheckInteractiveVisitor();
		n.accept(v, null);
		return v.isInteractive;
	}

	// state variables
	private boolean isInteractive = false;

	public Object visit(Ask node, Object data) {
		isInteractive = true;
		return data;
	}
}
