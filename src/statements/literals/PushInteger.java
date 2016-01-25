package statements.literals;

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
	public String toString() {
		return Long.toString(value);
	}

	@Override
	public PushInteger negate() {
		return new PushInteger(-value);
	}

	@Override
	public double doubleValue() {
		return value;
	}

	@Override
	public long longValue() {
		return value;
	}
	
	@Override
	public String name() {
		return " integer type";
	}
}
