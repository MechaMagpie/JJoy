package statements.functions;

import interpreter.NoBracesStack;

public class Id extends AbstractFunction {

	@Override
	public void eval(NoBracesStack stackState) {
		//This does nothing
	}

	@Override
	public String name() {
		return "id";
	}
}
