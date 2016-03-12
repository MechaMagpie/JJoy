package statements.functions.meta.branch;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.TernaryFunction;
import statements.literals.ListStatement;

public abstract class TypeBranch extends TernaryFunction<AbstractStatement, ListStatement, ListStatement> {

	@Override
	protected void eval(NoBracesStack stackState, AbstractStatement a, ListStatement b, ListStatement c)
			throws EvaluationException {
		if(typeChecked().isInstance(a))
			b.dequote(stackState);
		else
			c.dequote(stackState);
	}
	
	protected abstract Class<?> typeChecked();
}
