package statements.functions.tests;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.BinaryFunction;
import statements.literals.PushTruth;

public class Neq extends BinaryFunction<AbstractStatement, AbstractStatement> {

	@Override
	protected void eval(NoBracesStack stackState, AbstractStatement a, AbstractStatement b) throws EvaluationException {
		stackState.push(new PushTruth(a.equals(b)));
	}

	@Override
	public String name() {
		return "!=";	}

}
