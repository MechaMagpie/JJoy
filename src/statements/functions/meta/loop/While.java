package statements.functions.meta.loop;

import interpreter.LimitedRemoveStack;
import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.BinaryFunction;
import statements.functions.meta.WrongYieldException;
import statements.literals.ListStatement;
import statements.literals.PushTruth;

public class While extends BinaryFunction<statements.literals.ListStatement, ListStatement> {

	@Override
	protected void eval(NoBracesStack stackState, ListStatement a, ListStatement b) throws EvaluationException {
		loop: for(;;) {
			LimitedRemoveStack tempStk = new LimitedRemoveStack(stackState, 0);
			a.dequote(tempStk);
			tempStk.close();
			AbstractStatement yield = stackState.pop();
			if(!(yield instanceof PushTruth))
				throw new WrongYieldException(name(), PushTruth.class, yield.getClass());
			if(!((PushTruth)yield).boolValue())
				break loop;
			b.dequote(stackState);
		}
	}

	@Override
	public String name() {
		return "while";
	}

}
