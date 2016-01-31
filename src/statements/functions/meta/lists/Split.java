package statements.functions.meta.lists;

import interpreter.NoBracesStack;
import statements.literals.AggregateStatement;

public class Split extends AggregateTest {

	@Override
	protected void decide(NoBracesStack stackState, AggregateStatement pass, AggregateStatement fail) {
		stackState.push(pass);
		stackState.push(fail);
	}

	@Override
	public String name() {
		return "split";
	}

}
