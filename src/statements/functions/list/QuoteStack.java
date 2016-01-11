package statements.functions.list;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.MutableList;

public class QuoteStack extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		stackState.push(new MutableList(stackState));
	}

	@Override
	public String toString() {
		return "stack";
	}
}
