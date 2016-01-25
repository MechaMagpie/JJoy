package statements.functions;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.literals.PushString;

public class Name extends UnaryFunction<AbstractStatement> {

	@Override
	protected void eval(NoBracesStack stackState, AbstractStatement a) throws EvaluationException {
		stackState.push(new PushString(a.name()));
	}

	@Override
	public String name() {
		return "name";
	}

}
