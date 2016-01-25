package statements.functions.math;

import interpreter.NoBracesStack;
import statements.functions.BinaryFunction;
import statements.literals.NumberStatement;
import statements.literals.PushFloat;

public class Atan2 extends BinaryFunction<NumberStatement, NumberStatement> {


	@Override
	public String name() {
		return "atan2";
	}

	@Override
	protected void eval(NoBracesStack stackState, NumberStatement a, NumberStatement b) {
		stackState.push(new PushFloat(Math.atan2(a.doubleValue(), b.doubleValue())));
	}
}
