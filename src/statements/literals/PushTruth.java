package statements.literals;

public class PushTruth extends LiteralStatement implements NumericValue, Logical {
	private boolean value;
	
	public PushTruth(boolean value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return Boolean.toString(value);
	}

	@Override
	public long longValue() {
		return value ? 1 : 0;
	}

	@Override
	public String name() {
		return " truth value type";
	}

	public boolean boolValue() {
		return value;
	}
}
