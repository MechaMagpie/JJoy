package statements.functions.math;

import interpreter.NoBracesStack;
import statements.functions.UnaryFunction;
import statements.literals.NumberStatement;
import statements.literals.PushFloat;

public abstract class FloatMath extends UnaryFunction<NumberStatement> {

	@Override
	protected void eval(NoBracesStack stackState, NumberStatement a) {
		stackState.push(new PushFloat(mathOp(a.doubleValue())));
	}

	protected abstract double mathOp(double arg);
}
