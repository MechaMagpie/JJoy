package statements.functions;

import statements.EvaluationException;

@SuppressWarnings("serial")
public class MalformedListException extends EvaluationException {

	private String caller, list;

	public MalformedListException(String caller, String list) {
		this.caller = caller;
		this.list = list;
	}
	
	@Override
	public String helpfulMessage() {
		return "Wrong list format for operation \"" + caller + "\", list: " + list;
	}
}
