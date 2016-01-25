package statements.functions.list;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.functions.BinaryFunction;
import statements.functions.MismatchedArgumentsException;
import statements.literals.AggregateStatement;
import statements.literals.MutableList;
import statements.literals.PushBits;
import statements.literals.PushChar;
import statements.literals.PushInteger;
import statements.literals.PushString;

public abstract class Cswons<T, U> extends BinaryFunction<T, U> {

	protected void construct(NoBracesStack stackState, AggregateStatement a, AbstractStatement b) throws MismatchedArgumentsException {
		if(!a.matchingType(b)) throw new MismatchedArgumentsException(a.getClass(), b.getClass());
		if(a instanceof PushString)
			stackState.push(new PushString(((PushChar)b).charValue() + ((PushString) a).stringValue()));
		else if(a instanceof PushBits)
			stackState.push(new PushBits(((PushBits) a).setValue().add(((PushInteger)b).longValue())));
		else {
			if(stackState.canPop()) {
				((MutableList)a).body().addFirst(b);
				stackState.push(a);
			} else {
				MutableList lst = new MutableList(((MutableList)a).body());
				lst.body().addFirst(b);
				stackState.push(lst);
			}
		}
	}
}
