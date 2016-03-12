package statements.functions;

import interpreter.NoBracesStack;
import statements.EvaluationException;

public class Gc extends AbstractFunction {

	@Override
	public void eval(NoBracesStack stackState) throws EvaluationException {
		System.gc();
	}

	@Override
	public String name() {
		return "gc";
	}

}
