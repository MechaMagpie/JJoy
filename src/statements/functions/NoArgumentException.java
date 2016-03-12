package statements.functions;

import statements.EvaluationException;

@SuppressWarnings("serial")
public class NoArgumentException extends EvaluationException {
	private String caller;
	int argNrs;
	
	public NoArgumentException(String caller, int argNrs) {
		this.caller = caller;
		this.argNrs = argNrs;
	}
	
	@Override
	public String helpfulMessage() {
		return "Not enough arguments for function \"" + caller + "\", needs " + argNrs + " arguments";
	}
}
