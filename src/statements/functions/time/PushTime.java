package statements.functions.time;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.PushInteger;

public class PushTime extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		stackState.push(new PushInteger((int) (System.currentTimeMillis() / 1000)));
	}

	@Override
	public String toString() {
		return "time";
	}
}
