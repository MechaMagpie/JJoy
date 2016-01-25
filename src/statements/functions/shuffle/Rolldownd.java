package statements.functions.shuffle;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.functions.QuaternaryFunction;

public class Rolldownd extends QuaternaryFunction<AbstractStatement, AbstractStatement, AbstractStatement, AbstractStatement> {
	@Override
	protected void eval(NoBracesStack stackState, AbstractStatement a, AbstractStatement b, AbstractStatement c,
			AbstractStatement d) {
		stackState.push(b);
		stackState.push(c);
		stackState.push(a);
		stackState.push(d);
	}

	@Override
	public String name() {
		return "rolldownd";
	}
}
