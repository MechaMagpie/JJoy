package statements.functions.tests;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.literals.AggregateStatement;

public class In extends Contains<AbstractStatement, AggregateStatement> {

	@Override
	protected void eval(NoBracesStack stackState, AbstractStatement a, AggregateStatement b)
			throws EvaluationException {
		test(stackState, b, a);
	}

	@Override
	public String name() {
		return "in";
	}

}
