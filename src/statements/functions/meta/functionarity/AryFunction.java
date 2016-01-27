package statements.functions.meta.functionarity;

import interpreter.LimitedRemoveStack;
import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.functions.UnaryFunction;
import statements.literals.ListStatement;

public abstract class AryFunction extends UnaryFunction<ListStatement> {

	
	protected abstract int getArity();

	@Override
	protected void eval(NoBracesStack stackState, ListStatement a) throws EvaluationException {
		LimitedRemoveStack stackWrap = new LimitedRemoveStack(stackState, getArity());
		a.dequote(stackWrap);
		stackWrap.close();
	}
}
