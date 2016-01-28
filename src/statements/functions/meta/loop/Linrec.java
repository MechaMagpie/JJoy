package statements.functions.meta.loop;

import interpreter.LimitedRemoveStack;
import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.QuaternaryFunction;
import statements.functions.meta.WrongYieldException;
import statements.literals.ListStatement;
import statements.literals.PushTruth;

public class Linrec extends QuaternaryFunction<ListStatement, ListStatement, ListStatement, ListStatement> {

	@Override
	protected void eval(NoBracesStack stackState, ListStatement b, ListStatement t, ListStatement r1, ListStatement r2) throws EvaluationException {
		int recurCounter = 0;
		recursion: for(;;) {
			LimitedRemoveStack tempStk = new LimitedRemoveStack(stackState, 0);
			b.dequote(tempStk);
			tempStk.close();
			AbstractStatement res = stackState.pop();
			if(!(res instanceof PushTruth))
				throw new WrongYieldException(name(), PushTruth.class, res.getClass());
			if(((PushTruth)res).boolValue()) {
				t.dequote(stackState);
				break recursion;
			}
			else {
				recurCounter++;
				r1.dequote(stackState);
			}
		}
		for(; recurCounter > 0; recurCounter--) {
			r2.dequote(stackState);
		}
	}

	@Override
	public String name() {
		return "linrec";
	}

}
