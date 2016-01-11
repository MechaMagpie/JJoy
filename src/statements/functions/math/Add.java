package statements.functions.math;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.LiteralStatement;
import statements.NumberStatement;
import statements.PushChar;
import statements.PushFloat;
import statements.PushInteger;

public class Add extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		NumberStatement i = (NumberStatement) stackState.pop();
		LiteralStatement mp = (LiteralStatement) stackState.pop();
		if(mp instanceof PushChar && i instanceof PushInteger) {
			stackState.push(new PushChar(
					(char) ((int)((PushChar)mp).extractValue() + 
					i.extractValue().intValue())));
		} else {
			NumberStatement m = (NumberStatement) mp;
			if(i instanceof PushInteger && m instanceof PushInteger) {
				stackState.push(new PushInteger(
						m.extractValue().longValue() +
						i.extractValue().longValue()));
			}else {
				stackState.push(new PushFloat(
						m.extractValue().doubleValue() +
						i.extractValue().doubleValue()));
			} 
		}
	}

	@Override
	public String toString() {
		return "+";
	}
}
