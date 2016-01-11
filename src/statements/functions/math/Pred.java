package statements.functions.math;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.LiteralStatement;
import statements.PushChar;
import statements.PushInteger;

public class Pred extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		LiteralStatement m = (LiteralStatement) stackState.pop();
		if(m instanceof PushChar) 
			stackState.push(new PushChar((char) ((int)((PushChar)m).extractValue() - 1)));
		else
			stackState.push(new PushInteger(((PushInteger)m).extractValue() - 1));
	}

	@Override
	public String toString() {
		return "pred";
	}
}
