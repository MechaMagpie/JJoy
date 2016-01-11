package statements.functions.shuffle;

import interpreter.NoBracesStack;
import statements.AbstractStatement;

public class Pop extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		stackState.pop();
	}

	@Override
	public String toString() {
		return "pop";
	}
}
