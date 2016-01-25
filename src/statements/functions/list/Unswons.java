package statements.functions.list;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.literals.AggregateStatement;

public class Unswons extends Uncswons {

	@Override
	protected void eval(NoBracesStack stackState, AggregateStatement rest, AbstractStatement first) {
		stackState.push(rest);
		stackState.push(first);
	}

	@Override
	public String name() {
		return "unswons";
	}
}
