package statements.functions.list;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.functions.MismatchedArgumentsException;
import statements.functions.TernaryFunction;
import statements.literals.AggregateStatement;
import statements.literals.MutableList;
import statements.literals.PushBits;
import statements.literals.PushChar;
import statements.literals.PushInteger;
import statements.literals.PushString;
import util.ModuloBitset;

public class Enconcat extends TernaryFunction<AbstractStatement, AggregateStatement, AggregateStatement> {

	@Override
	protected void eval(NoBracesStack stackState, AbstractStatement a, AggregateStatement b, AggregateStatement c) throws MismatchedArgumentsException {
		if(!b.getClass().isInstance(c))
			//TODO: better exception
			throw new MismatchedArgumentsException(b.getClass(), c.getClass());
		if(!b.matchingType(a))
			throw new MismatchedArgumentsException(a.getClass(), b.getClass());
		if(b instanceof PushString)
			stackState.push(new PushString(((PushString)b).stringValue() + ((PushChar)a).charValue() + ((PushString)c).stringValue()));
		else if(b instanceof PushBits) {
			ModuloBitset bits = ((PushBits)b).setValue().or(((PushBits)c).setValue());
			bits = bits.add(((PushInteger)a).longValue());
			stackState.push(new PushBits(bits));
		} else {
			((MutableList)b).body().addLast(a);
			((MutableList)b).body().addAll(((MutableList)c).body());
			stackState.push(b);
		}
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return null;
	}

}
