package statements;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import interpreter.NoBracesStack;
import parser.Program;
import util.ListDeprinter;

public abstract class ListStatement extends AbstractStatement {
	protected LinkedList<AbstractStatement> body;
	
	public ListStatement(List<AbstractStatement> list) {
		body = new LinkedList<AbstractStatement>(list);
	}
	
	protected ListStatement() {}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append(ListDeprinter.dePrint(body));
		sb.append("]");
		return sb.toString();
	}
	
	public void dequote(NoBracesStack stackState) {
		Program p = new Program(body);
		p.eval(stackState);
	}
}
