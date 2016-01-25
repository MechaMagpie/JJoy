package statements.literals;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;

public class PushString extends AggregateStatement implements Comparable<PushString> {
	private String content;
	
	public PushString(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "\"" + content + "\"";
	}
	
	public String stringValue() {
		return content;
	}

	@Override
	public void eval(NoBracesStack stackState) throws EvaluationException {
		stackState.push(this);
	}

	@Override
	public String name() {
		return " string type";
	}

	@Override
	public boolean matchingType(AbstractStatement m) {
		return m instanceof PushChar;
	}

	@Override
	public long size() {
		return content.length();
	}

	@Override
	public int compareTo(PushString o) {
		return content.compareTo(o.stringValue());
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof PushString)
			return content.equals(((PushString) obj).content);
		else return false;
	}
}
