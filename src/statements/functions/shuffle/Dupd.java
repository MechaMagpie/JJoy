package statements.functions.shuffle;

import interpreter.NoBracesStack;
import statements.AbstractStatement;

public class Dupd extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		AbstractStatement z = stackState.pop();
		AbstractStatement y = stackState.pop();
		stackState.push(y);
		stackState.push(y);
		stackState.push(z);
	}

	@Override
	public String toString() {
		return "dupd";
	}
}
