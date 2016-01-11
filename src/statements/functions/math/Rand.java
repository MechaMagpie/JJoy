package statements.functions.math;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.PushInteger;

public class Rand extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		stackState.push((new PushInteger(stackState.random())));
	}

	@Override
	public String toString() {
		return "rand";
	}
}
