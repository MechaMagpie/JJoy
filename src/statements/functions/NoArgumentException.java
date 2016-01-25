package statements.functions;

import statements.EvaluationException;

public class NoArgumentException extends EvaluationException {
	private String caller;
	int argNrs;
	
	public NoArgumentException(String caller, int argNrs) {
		this.caller = caller;
		this.argNrs = argNrs;
	}
}
