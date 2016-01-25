package statements.functions.tests;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.literals.AggregateStatement;

public class Has extends Contains<AggregateStatement, AbstractStatement> {

	@Override
	protected void eval(NoBracesStack stackState, AggregateStatement a, AbstractStatement b)
			throws EvaluationException {
		test(stackState, a, b);
	}

	@Override
	public String name() {
		return "has";
	}

}
