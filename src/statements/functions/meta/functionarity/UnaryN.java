package statements.functions.meta.functionarity;

import interpreter.LimitedRemoveStack;
import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.NoArgumentException;
import statements.functions.UnaryFunction;
import statements.literals.ListStatement;

public abstract class UnaryN extends UnaryFunction<ListStatement> {

	@Override
	protected void eval(NoBracesStack stackState, ListStatement a) throws EvaluationException {
		AbstractStatement[] args = new AbstractStatement[repetitions()], results = new AbstractStatement[repetitions()];
		for(int i = repetitions() - 1; i >= 0; i--) {
			if(stackState.isEmpty())
				throw new NoArgumentException(name(), repetitions() + 1);
				args[i] = stackState.pop();
		}
		for(int i = 0; i < repetitions(); i++) {
			stackState.push(args[i]);
			LimitedRemoveStack tempStk = new LimitedRemoveStack(stackState, 1);
			a.dequote(tempStk);
			tempStk.close();
			results[i] = stackState.pop();
		}
		for(AbstractStatement s : results) {
			stackState.push(s);
		}
	}
	
	protected abstract int repetitions();
}
