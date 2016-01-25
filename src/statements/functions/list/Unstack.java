package statements.functions.list;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.functions.UnaryFunction;
import statements.literals.MutableList;

public class Unstack extends UnaryFunction<MutableList> {

	@Override
	public String name() {
		return "unstack";
	}

	@Override
	protected void eval(NoBracesStack stackState, MutableList a) throws EvaluationException {
		stackState.clear();
		stackState.addAll(a.body());
	}
}
