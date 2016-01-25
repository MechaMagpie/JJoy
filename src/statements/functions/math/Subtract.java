package statements.functions.math;

import interpreter.NoBracesStack;
import statements.functions.ArgumentTypeException;
import statements.functions.BinaryFunction;
import statements.literals.LiteralStatement;
import statements.literals.NumberStatement;
import statements.literals.PushChar;
import statements.literals.PushFloat;
import statements.literals.PushInteger;

public class Subtract extends BinaryFunction<LiteralStatement, NumberStatement> {

	@Override
	protected void eval(NoBracesStack stackState, LiteralStatement a, NumberStatement b) throws ArgumentTypeException {
		if(a instanceof PushChar) {
			if(!(b instanceof PushInteger)) throw new ArgumentTypeException(name(), PushInteger.class, 1);
			stackState.push(new PushChar((char) (a.longValue() - b.longValue())));
		} else if (a instanceof PushInteger && b instanceof PushInteger)
			stackState.push(new PushInteger(a.longValue() - b.longValue()));
		else
			stackState.push(new PushFloat(((NumberStatement)a).doubleValue() - b.doubleValue()));
	}

	@Override
	public String name() {
		return "-";
	}
}
