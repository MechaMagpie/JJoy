package statements.functions.math;

import interpreter.NoBracesStack;
import statements.functions.ArgumentTypeException;
import statements.functions.UnaryFunction;
import statements.literals.LiteralStatement;
import statements.literals.PushChar;
import statements.literals.PushInteger;

public class Succ extends UnaryFunction<LiteralStatement> {

	@Override
	protected void eval(NoBracesStack stackState, LiteralStatement a) throws ArgumentTypeException {
		if(a instanceof PushChar)
			stackState.push(new PushChar((char) (a.longValue() + 1)));
		else if(a instanceof PushInteger)
			stackState.push(new PushInteger(a.longValue() + 1));
		else
			throw new ArgumentTypeException(name(), PushInteger.class, 0);
	}

	@Override
	public String name() {
		return "succ";
	}
}
