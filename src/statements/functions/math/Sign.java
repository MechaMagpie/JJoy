package statements.functions.math;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.functions.UnaryFunction;
import statements.literals.NumberStatement;
import statements.literals.PushFloat;
import statements.literals.PushInteger;

public class Sign extends UnaryFunction<NumberStatement> {
	@Override
	protected void eval(NoBracesStack stackState, NumberStatement a) throws EvaluationException {
		if(a instanceof PushInteger) {
			stackState.push(new PushInteger(Long.signum(a.longValue())));
		} else {
			stackState.push(new PushFloat(Math.signum(a.doubleValue())));
		}
	}

	@Override
	public String name() {
		return "sign";
	}
}
