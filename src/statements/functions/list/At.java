package statements.functions.list;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.literals.AggregateStatement;
import statements.literals.PushInteger;

public class At extends Atof<AggregateStatement, PushInteger> {

	@Override
	protected void eval(NoBracesStack stackState, AggregateStatement a, PushInteger b) throws EvaluationException {
		extract(stackState, a, b);
	}

	@Override
	public String name() {
		return "at";
	}
}
