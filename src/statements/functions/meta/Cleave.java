package statements.functions.meta;

import interpreter.LimitedRemoveStack;
import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.functions.MismatchedArgumentsException;
import statements.functions.TernaryFunction;
import statements.literals.ListStatement;

public class Cleave extends TernaryFunction<AbstractStatement, ListStatement, ListStatement> {

	@Override
	protected void eval(NoBracesStack stackState, AbstractStatement a, ListStatement b, ListStatement c)
			throws MismatchedArgumentsException {
		stackState.push(a);
		LimitedRemoveStack tempStk = new LimitedRemoveStack(stackState, 1);
		b.dequote(tempStk);
		tempStk.close();
		tempStk = new LimitedRemoveStack(stackState, 1);
		c.dequote(tempStk);
		tempStk.close();
	}

	@Override
	public String name() {
		return "cleave";
	}

}
