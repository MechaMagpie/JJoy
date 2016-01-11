package statements.functions;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.PushTruth;

public class Choice extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		AbstractStatement f = stackState.pop();
		AbstractStatement t = stackState.pop();
		PushTruth b = (PushTruth) stackState.pop();
		if(b.extractValue())
			stackState.push(t);
		else
			stackState.push(f);
	}

	@Override
	public String toString() {
		return "choice";
	}
}
