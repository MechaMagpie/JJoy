package statements.functions.meta.branch;

import interpreter.LimitedRemoveStack;
import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.MismatchedArgumentsException;
import statements.functions.TernaryFunction;
import statements.functions.meta.WrongYieldException;
import statements.literals.ListStatement;
import statements.literals.PushTruth;

public class Ifte extends TernaryFunction<ListStatement, ListStatement, ListStatement> {

	@Override
	protected void eval(NoBracesStack stackState, ListStatement a, ListStatement b, ListStatement c)
			throws MismatchedArgumentsException, EvaluationException {
		LimitedRemoveStack tempStk = new LimitedRemoveStack(stackState, 0);
		a.dequote(tempStk);
		tempStk.close();
		AbstractStatement yield = stackState.pop();
		if(!(yield instanceof PushTruth))
				throw new WrongYieldException(name(), PushTruth.class, yield.getClass());
		if(((PushTruth)yield).boolValue())
			b.dequote(stackState);
		else
			c.dequote(stackState);
	}

	@Override
	public String name() {
		return "ifte";
	}

}
