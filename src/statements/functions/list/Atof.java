package statements.functions.list;

import interpreter.NoBracesStack;
import statements.functions.ArgumentSizeException;
import statements.functions.BinaryFunction;
import statements.literals.AggregateStatement;
import statements.literals.MutableList;
import statements.literals.PushBits;
import statements.literals.PushChar;
import statements.literals.PushInteger;
import statements.literals.PushString;

public abstract class Atof<T, U> extends BinaryFunction<T, U> {

	protected void extract(NoBracesStack stackState, AggregateStatement a, PushInteger n) throws ArgumentSizeException {
		if(n.longValue() > a.size() || n.longValue() < 0)
			throw new ArgumentSizeException(name(), n.longValue());
		if(a instanceof PushString)
			stackState.push(new PushChar(((PushString) a).stringValue().charAt((int) n.longValue())));
		else if (a instanceof PushBits)
			stackState.push(new PushInteger(((PushBits) a).setValue().get(n.longValue())));
		else
			stackState.push(((MutableList)a).body().get((int) n.longValue()));
	}
}
