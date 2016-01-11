package statements.functions.shuffle;

import interpreter.NoBracesStack;
import statements.AbstractStatement;

public class Swap extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		AbstractStatement y = stackState.pop();
		AbstractStatement x = stackState.pop();
		stackState.push(y);
		stackState.push(x);
	}

	@Override
	public String toString() {
		return "swap";
	}
}
