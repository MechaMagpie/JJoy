package statements.functions.shuffle;

import interpreter.NoBracesStack;
import statements.AbstractStatement;

public class Popd extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		AbstractStatement z = stackState.pop();
		stackState.pop();
		stackState.push(z);
	}

	@Override
	public String toString() {
		return "popd";
	}
}
