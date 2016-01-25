package statements.functions.shuffle;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.UnaryFunction;

public class Pop extends UnaryFunction<AbstractStatement> {
	@Override
	protected void eval(NoBracesStack stackState, AbstractStatement a) throws EvaluationException {}

	@Override
	public String name() {
		return "pop";
	}
}
