package statements;

import interpreter.NoBracesStack;

public abstract class AbstractStatement {

	public abstract void eval(NoBracesStack stackState) throws EvaluationException;

	public AbstractStatement dup() {
		return this;
	}
	
	public abstract String name();
}
