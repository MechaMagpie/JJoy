package statements.functions;

import interpreter.NoBracesStack;
import statements.EvaluationException;

public class Abort extends AbstractFunction {

	@Override
	public void eval(NoBracesStack stackState) throws EvaluationException {
		stackState.stop();
	}

	@Override
	public String name() {
		return "abort";
	}

}
