package statements.functions.tests;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.UnaryFunction;
import statements.literals.PushTruth;

public abstract class TypeTest extends UnaryFunction<AbstractStatement> {

	@Override
	protected void eval(NoBracesStack stackState, AbstractStatement a) throws EvaluationException {
		stackState.push(new PushTruth(typeTest(a)));
	}

	protected abstract boolean typeTest(AbstractStatement a);
}
