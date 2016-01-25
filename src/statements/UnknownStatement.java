package statements;

import interpreter.NoBracesStack;

public class UnknownStatement extends AbstractStatement {
	private String text;
	
	public UnknownStatement(String text) {
		this.text = text;
	}
	
	@Override
	public void eval(NoBracesStack stackState) throws UnknownFunctionException {
		throw new UnknownFunctionException(text);
	}

	@Override
	public String toString() {
		return "Unknown: " + text;
	}
	
	public String getName() {
		return text;
	}

	@Override
	public String name() {
		return " unknown";
	}
}
