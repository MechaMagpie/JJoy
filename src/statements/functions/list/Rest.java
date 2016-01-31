package statements.functions.list;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.functions.UnaryFunction;
import statements.literals.AggregateStatement;
import statements.literals.MutableList;
import statements.literals.PushBits;
import statements.literals.PushString;

public class Rest extends UnaryFunction<AggregateStatement> {

	@Override
	protected void eval(NoBracesStack stackState, AggregateStatement a) throws EvaluationException {
		if(a instanceof PushString)
			stackState.push(new PushString(((PushString) a).stringValue().substring(1)));
		else if(a instanceof PushBits)
			stackState.push(new PushBits(((PushBits) a).setValue().rest()));
		else
			((MutableList)a).body().pop();
		stackState.push(a);
	}

	@Override
	public String name() {
		return "rest";
	}
}
