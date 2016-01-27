package statements.functions.meta;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.UnaryFunction;
import statements.literals.MutableList;

public class App11 extends UnaryFunction<MutableList> {

	@Override
	protected void eval(NoBracesStack stackState, MutableList a) throws EvaluationException {
		a.dequote(stackState);
		AbstractStatement t = stackState.pop();
		stackState.pop();
		stackState.push(t);
		//I've replicated the function from the original, but I don't know what it's for
	}

	@Override
	public String name() {
		return "app11";
	}
	
}
