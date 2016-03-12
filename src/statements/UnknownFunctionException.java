package statements;

@SuppressWarnings("serial")
public class UnknownFunctionException extends EvaluationException {
	private String name;

	public UnknownFunctionException(String name) {
		this.name = name;
	}
	
	@Override
	public String helpfulMessage() {
		return "No function by name \"" + name + "\"";
	}
}
