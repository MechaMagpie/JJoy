package statements.functions.shuffle;

import interpreter.NoBracesStack;
import statements.AbstractStatement;

public class Rollup extends AbstractStatement{

	@Override
	public void eval(NoBracesStack stackState) {
		AbstractStatement z = stackState.pop();
		AbstractStatement y = stackState.pop();
		AbstractStatement x = stackState.pop();
		stackState.push(z);
		stackState.push(x);
		stackState.push(y);
	}

	@Override
	public String toString() {
		return "rollup";
	}
}
