package statements.functions.file;

import statements.EvaluationException;

@SuppressWarnings("serial")
public class FileIOError extends EvaluationException {
	private String cause, resource;
	
	public FileIOError(String cause, String resource) {
		this.cause = cause;
		this.resource = resource;
	}

	@Override
	public String helpfulMessage() {
		return "IO error from operation \"" + cause + "\" on resource \"" + resource + "\"";
	}
}
