package statements.functions.math;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.NumberStatement;
import statements.PushFloat;
import statements.PushInteger;

public class Acos extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		NumberStatement n1 = (NumberStatement) stackState.pop();
		stackState.push(new PushFloat(Math.acos(n1.extractValue().doubleValue())));
	}

	@Override
	public String toString() {
		return "acos";
	}
}
