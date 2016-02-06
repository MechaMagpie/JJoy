package statements.literals;

import java.util.Iterator;

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
	
	private class StringIterator implements Iterator<AbstractStatement> {
		private int index;
		
		public StringIterator() {
			index = 0;
		}
		
		@Override
		public boolean hasNext() {
			return index < content.length();
		}

		@Override
		public AbstractStatement next() {
			return new PushChar(content.charAt(index++));
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}

	@Override
	public Iterator<AbstractStatement> iterator() {
		return new StringIterator();
	}
}
