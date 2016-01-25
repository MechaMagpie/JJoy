package statements.functions;

import statements.AbstractStatement;
import statements.EvaluationException;

@SuppressWarnings("serial")
public class ArgumentTypeException extends EvaluationException {
	private String caller;
	private int argNr;
	private Class<?> correct;

	public ArgumentTypeException(String caller, Class<?> correct, int argNr) {
		this.caller = caller;
		this.correct = correct;
		this.argNr = argNr;
	}
}
