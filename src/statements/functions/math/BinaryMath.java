package statements.functions.math;

import interpreter.NoBracesStack;
import statements.functions.BinaryFunction;
import statements.literals.NumberStatement;
import statements.literals.PushFloat;
import statements.literals.PushInteger;

public abstract class BinaryMath extends BinaryFunction<NumberStatement, NumberStatement> {

	@Override
	protected void eval(NoBracesStack stackState, NumberStatement a, NumberStatement b) {
		if(a instanceof PushInteger && b instanceof PushInteger)
			stackState.push(new PushInteger(intMath(a.longValue(), b.longValue())));
		else
			stackState.push(new PushFloat(floatMath(a.doubleValue(), b.doubleValue())));
	}

	protected abstract double floatMath(double a, double b);

	protected abstract long intMath(long a, long b);
}
