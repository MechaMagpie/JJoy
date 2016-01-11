package statements.functions.logic;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.LiteralStatement;
import statements.PushBits;
import statements.PushTruth;

public class Not extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		LiteralStatement x = (LiteralStatement) stackState.pop();
		if(x instanceof PushBits) {
			stackState.push(new PushBits(((PushBits)x).extractValue().comp()));
		} else {
			stackState.push(new PushTruth(!((PushTruth)x).extractValue()));
		}
	}

	@Override
	public String toString() {
		return "not";
	}
}
