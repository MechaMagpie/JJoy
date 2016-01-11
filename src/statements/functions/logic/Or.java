package statements.functions.logic;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.LiteralStatement;
import statements.PushBits;
import statements.PushTruth;

public class Or extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		LiteralStatement y = (LiteralStatement) stackState.pop();
		LiteralStatement x = (LiteralStatement) stackState.pop();
		if(y instanceof PushBits) {
			stackState.push(new PushBits(((PushBits)y).extractValue().or(((PushBits)x).extractValue())));
		} else {
			stackState.push(new PushTruth(((PushTruth)x).extractValue() || ((PushTruth)y).extractValue()));
		}
	}

	@Override
	public String toString() {
		return "or";
	}
}
