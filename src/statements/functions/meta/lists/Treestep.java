package statements.functions.meta.lists;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.BinaryFunction;
import statements.literals.ListStatement;
import statements.literals.MutableList;

public class Treestep extends BinaryFunction<MutableList, ListStatement> {

	@Override
	protected void eval(NoBracesStack stackState, MutableList a, ListStatement b) throws EvaluationException {
		for(AbstractStatement m : a) {
			if(m instanceof MutableList)
				eval(stackState, (MutableList) m, b);
			else {
				stackState.push(m);
				b.dequote(stackState);
			}
		}
	}
	
	@Override
	public String name() {
		return "treestep";
	}
}
