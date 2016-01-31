package statements.functions.meta.lists;

import interpreter.NoBracesStack;
import statements.literals.AggregateStatement;

public class Filter extends AggregateTest {

	@Override
	protected void decide(NoBracesStack stackState, AggregateStatement pass, AggregateStatement fail) {
		stackState.push(pass);
	}

	@Override
	public String name() {
		return "filter";
	}

}
