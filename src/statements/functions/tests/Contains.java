package statements.functions.tests;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.BinaryFunction;
import statements.functions.MismatchedArgumentsException;
import statements.literals.AggregateStatement;
import statements.literals.MutableList;
import statements.literals.PushBits;
import statements.literals.PushChar;
import statements.literals.PushInteger;
import statements.literals.PushString;
import statements.literals.PushTruth;

public abstract class Contains<T, U> extends BinaryFunction<T, U> {

		protected void test(NoBracesStack stackState, AggregateStatement a, AbstractStatement b) throws EvaluationException {
		if(!a.matchingType(b))
			throw new MismatchedArgumentsException(a.getClass(), b.getClass());
		if(a instanceof PushString)
			stackState.push(new PushTruth(((PushString) a).stringValue().indexOf(((PushChar)b).charValue()) >= 0));
		else if(a instanceof PushBits)
			stackState.push(new PushTruth(((PushBits) a).setValue().contains(((PushInteger)b).longValue())));
		else
			stackState.push(new PushTruth(((MutableList)a).body().contains(b)));
	}
}
