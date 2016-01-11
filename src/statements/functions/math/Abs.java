package statements.functions.math;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.NumberStatement;
import statements.PushFloat;
import statements.PushInteger;

public class Abs extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		NumberStatement n1 = (NumberStatement) stackState.pop();
		if(n1 instanceof PushInteger) {
			stackState.push(new PushInteger(Math.abs(((PushInteger)n1).extractValue())));
		} else {
			stackState.push(new PushFloat(Math.abs(((PushFloat)n1).extractValue())));
		}
	}

	@Override
	public String toString() {
		return "abs";
	}
}