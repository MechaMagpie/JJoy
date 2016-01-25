package statements.functions.math;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.functions.UnaryFunction;
import statements.literals.NumberStatement;
import statements.literals.PushInteger;

public class Trunc extends UnaryFunction<NumberStatement> {

	@Override
	protected void eval(NoBracesStack stackState, NumberStatement a) throws EvaluationException {
		stackState.push(new PushInteger(a.longValue()));
	}

	@Override
	public String name() {
		return "trunc";
	}
}
