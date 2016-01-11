package statements.functions.shuffle;

import interpreter.NoBracesStack;
import statements.AbstractStatement;

public class Swapd extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		AbstractStatement z = stackState.pop();
		AbstractStatement y = stackState.pop();
		AbstractStatement x = stackState.pop();
		stackState.push(y);
		stackState.push(x);
		stackState.push(z);
	}

}
