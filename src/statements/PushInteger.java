package statements;

import interpreter.NoBracesStack;

public class PushInteger extends NumberStatement {
	long value;
	
	public PushInteger(long value) {
		this.value = value;
	}

	@Override
	public void eval(NoBracesStack stackState) {
		stackState.push(this);
	}

	@Override
	public Long extractValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return Long.toString(value);
	}

	@Override
	public PushInteger negate() {
		return new PushInteger(-value);
	}
}
