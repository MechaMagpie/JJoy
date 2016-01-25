package statements.functions.math;

import interpreter.NoBracesStack;
import statements.functions.UnaryFunction;
import statements.literals.NumberStatement;
import statements.literals.PushFloat;
import statements.literals.PushInteger;

public class Neg extends UnaryFunction<NumberStatement> {

	@Override
	protected void eval(NoBracesStack stackState, NumberStatement a) {
		if(a instanceof PushInteger) stackState.push(new PushInteger(-a.longValue()));
		else stackState.push(new PushFloat(-a.doubleValue()));
	}

	@Override
	public String name() {
		return "neg";
	}
}
