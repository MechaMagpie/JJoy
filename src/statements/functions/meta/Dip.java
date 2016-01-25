package statements.functions.meta;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.BinaryFunction;
import statements.literals.ListStatement;

public class Dip extends BinaryFunction<AbstractStatement, ListStatement>{

	@Override
	protected void eval(NoBracesStack stackState, AbstractStatement a, ListStatement b) throws EvaluationException {
		b.dequote(stackState);
		stackState.push(a);
	}

	@Override
	public String name() {
		return "dip";
	}
	
}
