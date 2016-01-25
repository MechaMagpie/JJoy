package statements.functions.list;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.functions.ArgumentSizeException;
import statements.functions.BinaryFunction;
import statements.literals.AggregateStatement;
import statements.literals.MutableList;
import statements.literals.PushBits;
import statements.literals.PushInteger;
import statements.literals.PushString;
import util.ModuloBitset;

public abstract class SubAggregate extends BinaryFunction<AggregateStatement, PushInteger> {

	@Override
	protected void eval(NoBracesStack stackState, AggregateStatement a, PushInteger b) throws EvaluationException {
		if(b.longValue() > a.size() || b.longValue() < 0)
			throw new ArgumentSizeException(name(), b.longValue());
		if(a instanceof PushString)
			stackState.push(new PushString(stringCase(((PushString) a).stringValue(), b.longValue())));
		else if (a instanceof PushBits)
			stackState.push(new PushBits(setCase(((PushBits)a).setValue(), b.longValue())));
		else {
			if(stackState.canPop()) {
				stackState.push(breakList((MutableList)a, b.longValue()));
			} else {
				stackState.push(copyRange((MutableList)a, b.longValue()));
			}
		}
	}

	protected abstract MutableList copyRange(MutableList a, long longValue);

	protected abstract MutableList breakList(MutableList a, long longValue);

	protected abstract ModuloBitset setCase(ModuloBitset setValue, long longValue);

	protected abstract String stringCase(String stringValue, long longValue);
}
