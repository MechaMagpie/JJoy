package statements;

import interpreter.NoBracesStack;

public abstract class AbstractStatement {

	public abstract void eval(NoBracesStack stackState);

	public AbstractStatement dup() {
		return this;
	}
}
