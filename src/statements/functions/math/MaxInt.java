package statements.functions.math;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.PushInteger;

public class MaxInt extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		stackState.push(new PushInteger(Long.MAX_VALUE));
	}

	@Override
	public String toString() {
		return "maxint";
	}
}
