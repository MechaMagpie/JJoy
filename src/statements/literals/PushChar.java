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
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof PushChar)) return false;
		return value == ((PushChar)obj).value;
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
