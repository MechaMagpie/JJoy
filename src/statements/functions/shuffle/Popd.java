package statements.functions.shuffle;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.BinaryFunction;

public class Popd extends BinaryFunction<AbstractStatement, AbstractStatement> {

	@Override
	protected void eval(NoBracesStack stackState, AbstractStatement a, AbstractStatement b) throws EvaluationException {
		stackState.push(b);
	}

	@Override
	public String name() {
		return "popd";
	}
}
