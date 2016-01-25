package statements.functions.math;

import interpreter.NoBracesStack;
import statements.functions.BinaryFunction;
import statements.literals.NumberStatement;
import statements.literals.PushInteger;

public class Min extends BinaryFunction<NumberStatement, NumberStatement> {

	@Override
	protected void eval(NoBracesStack stackState, NumberStatement a, NumberStatement b) {
		if(a instanceof PushInteger && b instanceof PushInteger)
			stackState.push(a.longValue() < b.longValue() ? a : b);
		else
			stackState.push(a.doubleValue() < b.doubleValue() ? a : b);
	}

	@Override
	public String name() {
		return "min";
	}
}
