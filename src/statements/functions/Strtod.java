package statements.functions;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.PushFloat;
import statements.PushString;

public class Strtod extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		PushString s = (PushString) stackState.pop();
		stackState.push(new PushFloat(Double.parseDouble(s.extractValue())));
	}

	@Override
	public String toString() {
		return "strtod";
	}
}
