package statements.functions.meta;

import interpreter.LimitedRemoveStack;
import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.MalformedListException;
import statements.functions.UnaryFunction;
import statements.literals.MutableList;
import statements.literals.PushTruth;

public class Cond extends UnaryFunction<MutableList> {

	@Override
	protected void eval(NoBracesStack stackState, MutableList a) throws EvaluationException {
		if(a.body().isEmpty()) throw new MalformedListException(name(), a.body().toString());
		boolean doDefault = true;
		AbstractStatement s = a.body().removeLast();
		if(!(s instanceof MutableList))
			throw new MalformedListException(name(), a.body().toString());
		MutableList tail = (MutableList) s;
		for(AbstractStatement c : a.body()) {
			if(!(c instanceof MutableList) || !(((MutableList)c).body().get(0) instanceof MutableList))
				throw new MalformedListException(name(), a.body().toString());
			LimitedRemoveStack tempStk = new LimitedRemoveStack(stackState, 0);
			((MutableList)((MutableList)c).body().removeFirst()).dequote(tempStk);
			tempStk.close();
			AbstractStatement b = stackState.pop();
			if (!(b instanceof PushTruth))
				throw new WrongYieldException(name(), PushTruth.class, b.getClass());
			if(((PushTruth)b).boolValue()) {
				((MutableList)c).dequote(stackState);
				doDefault = false;
				break;
			}
		} 
		if(doDefault)
			tail.dequote(stackState);
	}

	@Override
	public String name() {
		return "cond";
	}

}
