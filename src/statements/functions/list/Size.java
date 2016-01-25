package statements.functions.list;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.functions.UnaryFunction;
import statements.literals.AggregateStatement;
import statements.literals.PushInteger;

public class Size extends UnaryFunction<AggregateStatement> {

	@Override
	protected void eval(NoBracesStack stackState, AggregateStatement a) throws EvaluationException {
		stackState.push(new PushInteger(a.size()));
	}

	@Override
	public String name() {
		return "size";
	}
}
