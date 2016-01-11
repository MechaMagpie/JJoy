package statements;

import interpreter.NoBracesStack;

public abstract class LiteralStatement extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		stackState.push(this);
	}

	public abstract Object extractValue();
}
