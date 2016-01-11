package statements.functions;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.LiteralStatement;
import statements.PushChar;
import statements.PushInteger;
import statements.PushTruth;

public class Ord extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		LiteralStatement c = (LiteralStatement) stackState.pop();
		if(c instanceof PushChar) 
			stackState.push(new PushInteger(((PushChar) c).extractValue()));
		else if (c instanceof PushTruth) 
			stackState.push(new PushInteger((((PushTruth) c).extractValue()) ? 1 : 0));
		else
			stackState.push((PushInteger) c);
	}
	
	@Override
	public String toString() {
		return "ord";
	}
}
