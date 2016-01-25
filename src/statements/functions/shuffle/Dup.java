package statements.functions.shuffle;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.UnaryFunction;

public class Dup extends UnaryFunction<AbstractStatement> {

	@Override
	protected void eval(NoBracesStack stackState, AbstractStatement a) throws EvaluationException {
		stackState.push(a);
		stackState.push(a.dup());
	}

	@Override
	public String name() {
		return "dup";
	}
}
