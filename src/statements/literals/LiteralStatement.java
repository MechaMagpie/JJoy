package statements.literals;

import interpreter.NoBracesStack;

public abstract class LiteralStatement extends DataType implements NumericValue {

	@Override
	public void eval(NoBracesStack stackState) {
		stackState.push(this);
	}
	
	@Override
	public int compareTo(NumericValue o) {
		if(o instanceof PushFloat)		
			return Double.compare(longValue(), ((PushFloat) o).doubleValue());
		else
			return Long.compare(longValue(), o.longValue());
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof PushFloat)
			return (double) longValue() == ((PushFloat)obj).doubleValue();
		else if(obj instanceof NumericValue)
			return longValue() == ((NumericValue) obj).longValue();
		else return false;
	}
}
