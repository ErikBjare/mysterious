with open("./lang.ast") as f:
    lines = f.readlines()

nonterms = []

for line in lines:
    if line and not line.startswith("abstract"):
        exp = line.strip().split(":")[0].strip()
        if exp :
            nonterms.append(exp)

print("""aspect Visitor {
	/**
	 * Visitor interface for MiniC language. Each concrete node type must
	 * have a visit method.
	 */
	public interface Visitor {
		public Object visit(List node, Object data);
		public Object visit(Opt node, Object data);""")

z = """		public Object visit({} node, Object data);"""
for t in nonterms:
    print(z.format(t))

print("""}

	public Object ASTNode.accept(Visitor visitor, Object data) {
		throw new Error("Visitor: accept method not available for " + getClass().getName());
	}
	public Object List.accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
	}
	public Object Opt.accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
	}""")

a = """
	public Object {}.accept(Visitor visitor, Object data) {{
		return visitor.visit(this, data);
	}}
"""

for t in nonterms:
    print(a.format(t))
print("""

}
""")	
