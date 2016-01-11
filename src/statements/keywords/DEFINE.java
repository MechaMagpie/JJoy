package statements.keywords;

import interpreter.NoBracesStack;
import statements.AbstractStatement;

public class DEFINE extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		//TODO: better exception
		throw new RuntimeException("Attempting to evaulate delimiter: DEFINE");
	}

	@Override
	public String toString() {
		return "DEFINE";
	}
}
