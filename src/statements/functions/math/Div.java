package statements.functions.math;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.functions.BinaryFunction;
import statements.literals.NumberStatement;
import statements.literals.PushFloat;
import statements.literals.PushInteger;

public class Div extends BinaryFunction<NumberStatement, NumberStatement> {

	@Override
	protected void eval(NoBracesStack stackState, NumberStatement a, NumberStatement b) throws EvaluationException {
		if(a instanceof PushInteger && b instanceof PushInteger) {
			stackState.push(new PushInteger(a.longValue() / b.longValue()));
			stackState.push(new PushInteger(a.longValue() % b.longValue()));
		} else {
			stackState.push(new PushFloat(a.doubleValue() / b.doubleValue()));
			stackState.push(new PushFloat(a.doubleValue() % b.doubleValue()));
		}
	}

	@Override
	public String name() {
		return "div";
	}
}
