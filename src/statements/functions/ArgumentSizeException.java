package statements.functions;

import statements.EvaluationException;

public class ArgumentSizeException extends EvaluationException {
	private long size;
	private String name;
	
	public ArgumentSizeException(String name, long size) {
		this.name = name;
		this.size = size;
	}
}
