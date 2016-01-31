package statements.functions.meta.lists;

import interpreter.NoBracesStack;
import statements.literals.AggregateStatement;
import statements.literals.PushTruth;

public class All extends AggregateTest {

	@Override
	protected void decide(NoBracesStack stackState, AggregateStatement pass, AggregateStatement fail) {
		stackState.push(new PushTruth(fail.size() == 0));
	}

	@Override
	public String name() {
		return "all";
	}

}
