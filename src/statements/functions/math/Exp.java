package statements.functions.math;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.NumberStatement;
import statements.PushFloat;

public class Exp extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		NumberStatement f = (NumberStatement) stackState.pop();
		stackState.push(new PushFloat(Math.exp(f.extractValue().doubleValue())));
	}

	@Override
	public String toString() {
		return "exp";
	}
}
