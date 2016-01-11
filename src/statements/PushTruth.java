package statements;

public class PushTruth extends LiteralStatement {
	private boolean value;
	
	public PushTruth(boolean value) {
		this.value = value;
	}
	
	@Override
	public Boolean extractValue() {
		return value;
	}

	@Override
	public String toString() {
		return Boolean.toString(value);
	}
}
