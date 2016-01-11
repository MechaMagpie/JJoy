package statements;

import interpreter.NoBracesStack;

public class PushFloat extends NumberStatement {
	double value; 
	
	public PushFloat(double value) {
		this.value = value;
	}

	@Override
	public void eval(NoBracesStack stackState) {
		stackState.push(this);
	}

	@Override
	public Double extractValue() {
		return value;
	}

	@Override
	public String toString() {
		return Double.toString(value);
	}

	@Override
	public PushFloat negate() {
		return new PushFloat(-value);
	}
}
