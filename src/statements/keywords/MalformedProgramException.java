package statements.keywords;

import statements.EvaluationException;

@SuppressWarnings("serial")
public class MalformedProgramException extends EvaluationException {
	private String cause;
	
	public MalformedProgramException(String cause) {
		this.cause = cause;
	}
	
	@Override
	public String helpfulMessage() {
		return "Tried to evaluate non-function \"" + cause + "\"";
	}
}
