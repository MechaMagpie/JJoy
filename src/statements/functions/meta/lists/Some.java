package statements.functions.meta.lists;

import interpreter.NoBracesStack;
import statements.literals.AggregateStatement;
import statements.literals.PushTruth;

public class Some extends AggregateTest {

	@Override
	protected void decide(NoBracesStack stackState, AggregateStatement pass, AggregateStatement fail) {
		stackState.push(new PushTruth(pass.size() != 0));
	}

	@Override
	public String name() {
		return "some";
	}

}
