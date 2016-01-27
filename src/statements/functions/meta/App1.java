package statements.functions.meta;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.functions.UnaryFunction;
import statements.literals.MutableList;

public class App1 extends UnaryFunction<MutableList> {

	@Override
	protected void eval(NoBracesStack stackState, MutableList a) throws EvaluationException {
		a.dequote(stackState);
		//Far as I can tell this does the same thing as i.
	}

	@Override
	public String name() {
		return "app1";
	}

}
