package statements.functions.shuffle;

import interpreter.NoBracesStack;
import statements.AbstractStatement;

public class Dup extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		AbstractStatement x = stackState.pop();
		stackState.push(x.dup());
		stackState.push(x);
	}

	@Override
	public String toString() {
		return "dup";
	}
}
