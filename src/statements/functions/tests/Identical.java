package statements.functions.tests;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.functions.BinaryFunction;
import statements.literals.ListStatement;
import statements.literals.PushTruth;

public class Identical extends BinaryFunction<ListStatement, ListStatement> {

	@Override
	protected void eval(NoBracesStack stackState, ListStatement a, ListStatement b) throws EvaluationException {
		stackState.push(new PushTruth(a.identical(b)));
	}

	@Override
	public String name() {
		return "equal";
	}

}
