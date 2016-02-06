package statements.functions.meta.lists;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.MismatchedArgumentsException;
import statements.functions.TernaryFunction;
import statements.literals.AggregateStatement;
import statements.literals.ListStatement;

public class Fold extends TernaryFunction<AggregateStatement, AbstractStatement, ListStatement> {

	@Override
	protected void eval(NoBracesStack stackState, AggregateStatement a, AbstractStatement v0, ListStatement p)
			throws MismatchedArgumentsException, EvaluationException {
		stackState.push(v0);
		for(AbstractStatement m : a) {
			stackState.push(m);
			p.dequote(stackState);
		}
	}

	@Override
	public String name() {
		return "fold";
	}

}
