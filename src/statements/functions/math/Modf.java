package statements.functions.math;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.NumberStatement;
import statements.PushFloat;
import statements.PushInteger;

public class Modf extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		double f = ((NumberStatement)stackState.pop()).extractValue().doubleValue();
		int intVal = (int) f;
		double floatVal = f - intVal;
		stackState.push(new PushFloat(floatVal));
		stackState.push(new PushInteger(intVal));
	}

	@Override
	public String toString() {
		return "modf";
	}
}
