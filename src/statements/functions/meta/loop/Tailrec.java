package statements.functions.meta.loop;

import interpreter.LimitedRemoveStack;
import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.MismatchedArgumentsException;
import statements.functions.TernaryFunction;
import statements.functions.meta.WrongYieldException;
import statements.literals.ListStatement;
import statements.literals.PushTruth;

public class Tailrec extends TernaryFunction<ListStatement, ListStatement, ListStatement> {

	@Override
	protected void eval(NoBracesStack stackState, ListStatement p, ListStatement t, ListStatement r1)
			throws MismatchedArgumentsException, EvaluationException {
		recursion: for(;;) {
			LimitedRemoveStack tempStk = new LimitedRemoveStack(stackState, 0);
			p.dequote(tempStk);
			tempStk.close();
			AbstractStatement yield = stackState.pop();
			if(!(yield instanceof PushTruth))
				throw new WrongYieldException(name(), PushTruth.class, yield.getClass());
			if(((PushTruth)yield).boolValue()) {
				t.dequote(stackState);
				break recursion;
			} else {
				r1.dequote(stackState);
			}
		}

	}

	@Override
	public String name() {
		return "tailrec";
	}

}
