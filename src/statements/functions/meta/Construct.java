package statements.functions.meta;

import interpreter.LimitedRemoveStack;
import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.BinaryFunction;
import statements.functions.MalformedListException;
import statements.literals.MutableList;

public class Construct extends BinaryFunction<MutableList, MutableList> {

	@Override
	protected void eval(NoBracesStack stackState, MutableList a, MutableList b) throws EvaluationException {
		//I have honestly no idea what this is even for
		LimitedRemoveStack tempStk = new LimitedRemoveStack(stackState, 0);
		a.eval(tempStk);
		tempStk.close();
		stackState.pop();
		for(AbstractStatement s : b.body()) {
			if(!(s instanceof MutableList))
				throw new MalformedListException(name(), b.toString());
			((MutableList)s).dequote(stackState);
		}
	}

	@Override
	public String name() {
		return "construct";
	}

}
