package statements.functions.shuffle;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.functions.TernaryFunction;

public class Rollup extends TernaryFunction<AbstractStatement, AbstractStatement, AbstractStatement>{

	@Override
	protected void eval(NoBracesStack stackState, AbstractStatement a, AbstractStatement b, AbstractStatement c) {
		stackState.push(c);
		stackState.push(a);
		stackState.push(b);
	}

	@Override
	public String name() {
		return "rollup";
	}
}
