package statements.functions.meta.loop;

import java.util.LinkedList;

import interpreter.LimitedRemoveStack;
import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.QuaternaryFunction;
import statements.functions.meta.WrongYieldException;
import statements.literals.ListStatement;
import statements.literals.MutableList;
import statements.literals.PushTruth;

public class Genrec extends QuaternaryFunction<ListStatement, ListStatement, ListStatement, ListStatement> {

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
			LinkedList<AbstractStatement> tempLst = new LinkedList<AbstractStatement>();
			tempLst.add(b);
			tempLst.add(t);
			tempLst.add(r1);
			tempLst.add(r2);
			tempLst.add(this);
			stackState.push(new MutableList(tempLst));
			r2.dequote(stackState);
		}
	}

	@Override
	public String name() {
		return "genrec";
	}

}
