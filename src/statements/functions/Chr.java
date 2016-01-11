package statements.functions;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.LiteralStatement;
import statements.PushChar;
import statements.PushInteger;
import statements.PushTruth;

public class Chr extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		LiteralStatement i = (LiteralStatement) stackState.pop();
		if(i instanceof PushChar)
			stackState.push(i);
		else if (i instanceof PushTruth)
			stackState.push(new PushChar((char) (((PushTruth) i).extractValue() ? 1 : 0)));
		else
			stackState.push(new PushChar((char) ((PushInteger)i).extractValue().intValue()));
	}

	@Override
	public String toString() {
		return "chr";
	}
}
