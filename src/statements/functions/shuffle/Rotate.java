package statements.functions.shuffle;

import interpreter.NoBracesStack;
import statements.AbstractStatement;

public class Rotate extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		AbstractStatement z = stackState.pop();
		AbstractStatement y = stackState.pop();
		AbstractStatement x = stackState.pop();
		stackState.push(z);
		stackState.push(y);
		stackState.push(x);
	}

	@Override
	public String toString() {
		return "rotate";
	}
}
