package statements;

import interpreter.NoBracesStack;

public class UnknownStatement extends AbstractStatement {
	private String text;
	
	public UnknownStatement(String text) {
		this.text = text;
	}
	
	@Override
	public void eval(NoBracesStack stackState) {
		//TODO: Better exception
		throw new RuntimeException("No function by name " + text + "!");
	}

	@Override
	public String toString() {
		return "Unknown: " + text;
	}
	
	public String getName() {
		return text;
	}
}
