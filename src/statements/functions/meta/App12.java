package statements.functions.meta;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.UnaryFunction;
import statements.literals.MutableList;

public class App12 extends UnaryFunction<MutableList> {

	@Override
	protected void eval(NoBracesStack stackState, MutableList a) throws EvaluationException {
		a.dequote(stackState);
		AbstractStatement z = stackState.pop();
		a.dequote(stackState);
		AbstractStatement y = stackState.pop();
		stackState.pop();
		stackState.push(y);
		stackState.push(z);
		//Don't know why this exists
	}

	@Override
	public String name() {
		return "app12";
	}

}
