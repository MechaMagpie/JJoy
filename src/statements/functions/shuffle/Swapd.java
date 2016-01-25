package statements.functions.shuffle;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.functions.TernaryFunction;

public class Swapd extends TernaryFunction<AbstractStatement, AbstractStatement, AbstractStatement> {
	@Override
	protected void eval(NoBracesStack stackState, AbstractStatement a, AbstractStatement b, AbstractStatement c) {
		stackState.push(b);
		stackState.push(a);
		stackState.push(c);
	}

	@Override
	public String name() {
		return "swapd";
	}

}
