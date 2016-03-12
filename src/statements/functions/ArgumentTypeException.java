package statements.functions;

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
	
	@Override
	public String helpfulMessage() {
		return "Argument #" + argNr + " of function \"" + caller + "\" of wrong type, needs to be \"" + correct.getName() + "\"";
	}
}
