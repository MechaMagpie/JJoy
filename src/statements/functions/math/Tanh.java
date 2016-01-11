package statements.functions.math;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.NumberStatement;
import statements.PushFloat;

public class Tanh extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		NumberStatement f = (NumberStatement) stackState.pop();
		stackState.push(new PushFloat(Math.tanh(f.extractValue().doubleValue())));
	}

	@Override
	public String toString() {
		return "tanh";
	}
}
