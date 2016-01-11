package statements.functions.shuffle;

import interpreter.NoBracesStack;
import statements.AbstractStatement;

public class Rollupd extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		AbstractStatement w = stackState.pop();
		AbstractStatement z = stackState.pop();
		AbstractStatement y = stackState.pop();
		AbstractStatement x = stackState.pop();
		stackState.push(z);
		stackState.push(x);
		stackState.push(y);
		stackState.push(w);
	}

	@Override
	public String toString() {
		return "rollupd";
	}
}
