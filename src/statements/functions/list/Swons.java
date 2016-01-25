package statements.functions.list;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.literals.AggregateStatement;

public class Swons extends Cswons<AggregateStatement, AbstractStatement> {

	@Override
	protected void eval(NoBracesStack stackState, AggregateStatement a, AbstractStatement b)
			throws EvaluationException {
		construct(stackState, a, b);
	}

	@Override
	public String name() {
		return "swons";
	}
}
