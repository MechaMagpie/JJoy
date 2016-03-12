package statements.functions;

import statements.EvaluationException;

@SuppressWarnings("serial")
public class ArgumentSizeException extends EvaluationException {
	private long size;
	private String name;
	
	public ArgumentSizeException(String name, long size) {
		this.name = name;
		this.size = size;
	}
	
	@Override
	public String helpfulMessage() {
		return "Integer " + size + " outside of allowable range for \"" + name + "\"";
	}
}
