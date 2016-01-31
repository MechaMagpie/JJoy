package statements.functions.list;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.UnaryFunction;
import statements.literals.AggregateStatement;
import statements.literals.MutableList;
import statements.literals.PushBits;
import statements.literals.PushChar;
import statements.literals.PushInteger;
import statements.literals.PushString;
import util.ModuloBitset;

public abstract class Uncswons extends UnaryFunction<AggregateStatement> {
	
	@Override
	protected void eval(NoBracesStack stackState, AggregateStatement a) throws EvaluationException {
		if(a instanceof PushString) {
			String str = ((PushString) a).stringValue();
			eval(stackState, new PushString(str.substring(1)), new PushChar(str.charAt(0)));
		} else if (a instanceof PushBits) {
			ModuloBitset bits = ((PushBits) a).setValue();
			eval(stackState, new PushBits(bits.rest()), new PushInteger(bits.first()));
		} else {
			eval(stackState, a, ((MutableList)a).body().remove(0));
		}
	}

	protected abstract void eval(NoBracesStack stackState, AggregateStatement rest, AbstractStatement first);

}
