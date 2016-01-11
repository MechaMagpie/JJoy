package statements.functions.math;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.NumberStatement;
import statements.PushFloat;

public class Atan2 extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		NumberStatement g = (NumberStatement) stackState.pop();
		NumberStatement f = (NumberStatement) stackState.pop();		
		stackState.push(new PushFloat(Math.atan2(f.extractValue().doubleValue(), g.extractValue().doubleValue())));
	}

}
