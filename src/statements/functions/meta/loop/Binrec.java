package statements.functions.meta.loop;

import interpreter.LimitedRemoveStack;
import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.QuaternaryFunction;
import statements.functions.meta.WrongYieldException;
import statements.literals.ListStatement;
import statements.literals.PushTruth;

public class Binrec extends QuaternaryFunction<ListStatement, ListStatement, ListStatement, ListStatement> {

	@Override
	protected void eval(NoBracesStack stackState, ListStatement b, ListStatement t, ListStatement r1, ListStatement r2)
			throws EvaluationException {
		LimitedRemoveStack tempStk = new LimitedRemoveStack(stackState, 0);
		b.dequote(tempStk);
		tempStk.close();
		AbstractStatement yield = stackState.pop();
		if(!(yield instanceof PushTruth))
			throw new WrongYieldException(name(), PushTruth.class, yield.getClass());
		if(((PushTruth)yield).boolValue())
			t.dequote(stackState);
		else {
			r1.dequote(stackState);
			AbstractStatement l1 = stackState.pop(), l2 = stackState.pop();
			if(!(l1 instanceof ListStatement))
				throw new WrongYieldException(name(), ListStatement.class, l1.getClass());
			if(!(l2 instanceof ListStatement))
				throw new WrongYieldException(name(), ListStatement.class, l2.getClass());
			stackState.push(l2);
			eval(stackState, b, t, r1, r2);
			stackState.push(l1);
			eval(stackState, b, t, r1, r2);
			r2.dequote(stackState);
		}
	}

	@Override
	public String name() {
		return "binrec";
	}

}
