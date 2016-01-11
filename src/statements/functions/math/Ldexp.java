package statements.functions.math;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.NumberStatement;
import statements.PushFloat;

public class Ldexp extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		NumberStatement i = (NumberStatement) stackState.pop();
		NumberStatement f = (NumberStatement) stackState.pop();
		stackState.push(new PushFloat(f.extractValue().doubleValue() * Math.pow(2, i.extractValue().doubleValue())));
	}

	@Override
	public String toString() {
		return "ldexp";
	}
}
