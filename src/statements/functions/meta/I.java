package statements.functions.meta;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.functions.UnaryFunction;
import statements.literals.ListStatement;

public class I extends UnaryFunction<ListStatement> {

	@Override
	protected void eval(NoBracesStack stackState, ListStatement a) throws EvaluationException {
		a.dequote(stackState);
	}

	@Override
	public String name() {
		return "i";
	}
}
