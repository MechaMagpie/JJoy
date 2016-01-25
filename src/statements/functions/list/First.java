package statements.functions.list;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.functions.UnaryFunction;
import statements.literals.AggregateStatement;
import statements.literals.MutableList;
import statements.literals.PushBits;
import statements.literals.PushChar;
import statements.literals.PushInteger;
import statements.literals.PushString;

public class First extends UnaryFunction<AggregateStatement> {

	@Override
	protected void eval(NoBracesStack stackState, AggregateStatement a) throws EvaluationException {
		if(a instanceof PushString)
			stackState.push(new PushChar(((PushString) a).stringValue().charAt(0)));
		else if (a instanceof PushBits)
			stackState.push(new PushInteger(((PushBits) a).setValue().first()));
		else
			stackState.push(((MutableList)a).body().peek());
	}

	@Override
	public String name() {
		return "first";
	}
}
