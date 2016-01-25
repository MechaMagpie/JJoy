package statements.functions.math;

import interpreter.NoBracesStack;
import statements.functions.AbstractFunction;
import statements.literals.PushInteger;

public class MaxInt extends AbstractFunction {

	@Override
	public void eval(NoBracesStack stackState) {
		stackState.push(new PushInteger(Long.MAX_VALUE));
	}

	@Override
	public String name() {
		return "maxint";
	}
}
