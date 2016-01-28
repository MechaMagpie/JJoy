package statements.functions.meta.branch;

import interpreter.NoBracesStack;
import statements.functions.MismatchedArgumentsException;
import statements.functions.TernaryFunction;
import statements.literals.ListStatement;
import statements.literals.PushTruth;

public class Branch extends TernaryFunction<PushTruth, ListStatement, ListStatement> {

	@Override
	protected void eval(NoBracesStack stackState, PushTruth a, ListStatement b, ListStatement c)
			throws MismatchedArgumentsException {
		if(a.boolValue())
			b.dequote(stackState);
		else
			c.dequote(stackState);
	}

	@Override
	public String name() {
		return "branch";
	}

}
