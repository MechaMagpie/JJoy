package statements.functions.meta.lists;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.BinaryFunction;
import statements.literals.AggregateStatement;
import statements.literals.ListStatement;

public class Step extends BinaryFunction<AggregateStatement, ListStatement> {

	@Override
	protected void eval(NoBracesStack stackState, AggregateStatement a, ListStatement b) throws EvaluationException {
		for(AbstractStatement m : a) {
			stackState.push(m);
			b.dequote(stackState);
		}
	}

	@Override
	public String name() {
		return "step";
	}

}
