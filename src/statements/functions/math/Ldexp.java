package statements.functions.math;

import interpreter.NoBracesStack;
import statements.functions.BinaryFunction;
import statements.literals.NumberStatement;
import statements.literals.PushFloat;

public class Ldexp extends BinaryFunction<NumberStatement, NumberStatement> {

	@Override
	protected void eval(NoBracesStack stackState, NumberStatement a, NumberStatement b) {
		stackState.push(new PushFloat(a.doubleValue() * Math.pow(2, b.doubleValue())));
	}

	@Override
	public String name() {
		return "ldexp";
	}
}
