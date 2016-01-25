package statements.literals;

public class PushChar extends LiteralStatement {
	private char value;
	
	public PushChar(char value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "\'" + Character.toString(value);
	}
	
	public char charValue() {
		return value;
	}

	@Override
	public long longValue() {
		return (long) value;
	}

	@Override
	public String name() {
		return " character type";
	}
}
