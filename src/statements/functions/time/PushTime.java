package statements.functions.time;

import interpreter.NoBracesStack;
import statements.functions.AbstractFunction;
import statements.literals.PushInteger;

public class PushTime extends AbstractFunction {

	@Override
	public void eval(NoBracesStack stackState) {
		stackState.push(new PushInteger((int) (System.currentTimeMillis() / 1000L)));
	}

	@Override
	public String name() {
		return "time";
	}
}
