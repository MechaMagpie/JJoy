package statements.functions.meta;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.functions.UnaryFunction;
import statements.literals.MutableList;

public class X extends UnaryFunction<MutableList> {

	@Override
	protected void eval(NoBracesStack stackState, MutableList a) throws EvaluationException {
		stackState.push(a);
		a.dequote(stackState);
	}

	@Override
	public String name() {
		return "x";
	}

}
