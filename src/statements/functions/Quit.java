package statements.functions;

import interpreter.NoBracesStack;
import statements.EvaluationException;

public class Quit extends AbstractFunction {

	@Override
	public void eval(NoBracesStack stackState) throws EvaluationException {
		stackState.stop();
		stackState.quit();
	}

	@Override
	public String name() {
		return "quit";
	}

}
