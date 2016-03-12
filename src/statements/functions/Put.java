package statements.functions;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;

public class Put extends UnaryFunction<AbstractStatement> {

	@Override
	protected void eval(NoBracesStack stackState, AbstractStatement a) throws EvaluationException {
		System.out.println(String.valueOf(a));
	}

	@Override
	public String name() {
		return "put";
	}

}
