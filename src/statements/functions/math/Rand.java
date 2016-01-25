package statements.functions.math;

import interpreter.NoBracesStack;
import statements.functions.AbstractFunction;
import statements.literals.PushInteger;

public class Rand extends AbstractFunction {

	@Override
	public void eval(NoBracesStack stackState) {
		stackState.push((new PushInteger(stackState.random())));
	}

	@Override
	public String name() {
		return "rand";
	}
}
