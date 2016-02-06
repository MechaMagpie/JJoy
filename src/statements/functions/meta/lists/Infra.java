package statements.functions.meta.lists;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.functions.BinaryFunction;
import statements.literals.ListStatement;
import statements.literals.MutableList;

public class Infra extends BinaryFunction<MutableList, ListStatement> {

	@Override
	protected void eval(NoBracesStack stackState, MutableList a, ListStatement b) throws EvaluationException {
		NoBracesStack infraStack = new NoBracesStack(a.body());
		b.dequote(infraStack);
		stackState.push(new MutableList(infraStack));
	}

	@Override
	public String name() {
		return "infra";
	}

}
