package statements.functions.math;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.NumberStatement;
import statements.PushFloat;

public class Asin extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		NumberStatement n1 = (NumberStatement) stackState.pop();
		stackState.push(new PushFloat(Math.asin(n1.extractValue().doubleValue())));
	}

	@Override
	public String toString() {
		return "asin";
	}
}
