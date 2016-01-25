package statements.literals;

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
	public String toString() {
		return Double.toString(value);
	}

	@Override
	public PushFloat negate() {
		return new PushFloat(-value);
	}

	@Override
	public double doubleValue() {
		return value;
	}

	@Override
	public long longValue() {
		return (long) value;
	}

	@Override
	public String name() {
		return " float type";
	}
	
	@Override
	public int compareTo(NumericValue o) {
		if(o instanceof PushFloat)
			return Double.compare(doubleValue(), ((PushFloat) o).doubleValue());
		else
			return Double.compare(doubleValue(), o.longValue());
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof PushFloat)
			return doubleValue() == ((PushFloat)obj).doubleValue();
		else if(obj instanceof NumericValue)
			return doubleValue() == (double) ((NumericValue)obj).longValue();
		else return false;
	}
}
