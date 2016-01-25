package statements.literals;

import java.util.LinkedList;
import java.util.List;
import interpreter.NoBracesStack;
import parser.Program;
import statements.AbstractStatement;
import util.ListDeprinter;

public abstract class ListStatement extends AggregateStatement implements NumericValue {
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
	
	@Override
	public long longValue() {
		return body.isEmpty() ? 0 : number;
	}
	
	@Override
	public String name() {
		return " list type";
	}
	
	@Override
	public boolean matchingType(AbstractStatement m) {
		return true;
	}
	
	@Override
	public long size() {
		return body.size();
	}
	
	@Override
	public int compareTo(NumericValue o) {
		if(o instanceof PushFloat)
			return Double.compare(longValue(), ((PushFloat) o).doubleValue());
		else
			return Long.compare(longValue(), o.longValue());
	}
	
	@Override
	public boolean equals(Object obj) {
		if(size() != 0) return false;
		if(obj instanceof PushFloat)
			return ((PushFloat) obj).doubleValue() == 0;
		else if(obj instanceof NumericValue)
			return ((NumericValue) obj).longValue() == 0;
		else return false;
	}
}
