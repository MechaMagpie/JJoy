package statements.functions.math;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.NumberStatement;
import statements.PushFloat;
import statements.PushInteger;

public class Div extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		NumberStatement j = (NumberStatement) stackState.pop();
		NumberStatement i = (NumberStatement) stackState.pop();
		if(j instanceof PushInteger && i instanceof PushInteger) {
			stackState.push(new PushInteger(
					i.extractValue().longValue() /
					j.extractValue().longValue()));
			stackState.push(new PushInteger(
							i.extractValue().longValue() %
							j.extractValue().longValue()));
		}else {
			stackState.push(new PushFloat(
					i.extractValue().doubleValue() /
					j.extractValue().doubleValue()));
			stackState.push(new PushFloat(
					i.extractValue().doubleValue() %
					j.extractValue().doubleValue()));
		}
	}

}
