package statements.functions.list;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.literals.AggregateStatement;
import statements.literals.PushInteger;

public class Of extends Atof<PushInteger, AggregateStatement> {

	@Override
	protected void eval(NoBracesStack stackState, PushInteger a, AggregateStatement b) throws EvaluationException {
		extract(stackState, b, a);
	}

	@Override
	public String name() {
		return "of";
	}
}
