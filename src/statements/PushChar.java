package statements;

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
	public Character extractValue() {
		return value;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof PushChar)) return false;
		return value == ((PushChar)obj).value;
	}
}
