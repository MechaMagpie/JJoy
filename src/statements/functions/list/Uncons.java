package statements.functions.list;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.literals.AggregateStatement;

public class Uncons extends Uncswons {

	@Override
	protected void eval(NoBracesStack stackState, AggregateStatement rest, AbstractStatement first) {
		stackState.push(first);
		stackState.push(rest);
	}

	@Override
	public String name() {
		return "uncons";
	}
}
