package statements.functions.math;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.NumberStatement;
import statements.PushFloat;

public class Pow extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		NumberStatement g = (NumberStatement) stackState.pop();
		NumberStatement f = (NumberStatement) stackState.pop();
		stackState.push(new PushFloat( Math.pow(f.extractValue().doubleValue(), g.extractValue().doubleValue())));
	}

	@Override
	public String toString() {
		return "pow";
	}
}
