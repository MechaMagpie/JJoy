package statements.functions.list;

import interpreter.NoBracesStack;
import statements.functions.AbstractFunction;
import statements.literals.MutableList;

public class QuoteStack extends AbstractFunction {

	@Override
	public void eval(NoBracesStack stackState) {
		stackState.push(new MutableList(stackState));
	}

	@Override
	public String name() {
		return "stack";
	}
}
