package statements.keywords;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;

public abstract class Delimiter extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) throws EvaluationException {
		throw new MalformedProgramException(name());
	}

	@Override
	public String toString() {
		return name();
	}
}
