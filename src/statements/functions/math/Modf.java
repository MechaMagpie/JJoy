package statements.functions.math;

import interpreter.NoBracesStack;
import statements.functions.UnaryFunction;
import statements.literals.NumberStatement;
import statements.literals.PushFloat;
import statements.literals.PushInteger;

public class Modf extends UnaryFunction<NumberStatement> {

	@Override
	protected void eval(NoBracesStack stackState, NumberStatement a) {
		double f = a.doubleValue();
		int intVal = (int) f;
		double floatVal = f - intVal;
		stackState.push(new PushFloat(floatVal));
		stackState.push(new PushInteger(intVal));
	}

	@Override
	public String name() {
		return "modf";
	}
}
