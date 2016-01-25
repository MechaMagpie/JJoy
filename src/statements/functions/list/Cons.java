package statements.functions.list;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.literals.AggregateStatement;

public class Cons extends Cswons<AbstractStatement, AggregateStatement> {

	@Override
	protected void eval(NoBracesStack stackState, AbstractStatement a, AggregateStatement b)
			throws EvaluationException {
		construct(stackState, b, a);
		
	}

	@Override
	public String name() {
		return "cons";
	}
}
