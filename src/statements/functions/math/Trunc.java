package statements.functions.math;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.NumberStatement;
import statements.PushFloat;
import statements.PushInteger;

public class Trunc extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		NumberStatement f = (NumberStatement) stackState.pop();
		stackState.push(new PushInteger(Math.round(f.extractValue().doubleValue())));
	}

}
