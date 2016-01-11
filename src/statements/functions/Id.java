package statements.functions;

import interpreter.NoBracesStack;
import statements.AbstractStatement;

public class Id extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		//This does nothing
	}

	@Override
	public String toString() {
		return "id";
	}
}
