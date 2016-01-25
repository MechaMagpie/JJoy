package statements.functions.shuffle;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.functions.TernaryFunction;

public class Rolldown extends TernaryFunction<AbstractStatement, AbstractStatement, AbstractStatement> {
	
	@Override
	protected void eval(NoBracesStack stackState, AbstractStatement a, AbstractStatement b, AbstractStatement c) {
		stackState.push(b);
		stackState.push(c);
		stackState.push(a);
	}

	@Override
	public String name() {
		return "rolldown";
	}
}
