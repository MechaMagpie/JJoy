package statements.keywords;

import interpreter.NoBracesStack;
import statements.AbstractStatement;

public class DEFINE extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) throws MalformedProgramException {
		throw new MalformedProgramException("DEFINE");
	}

	@Override
	public String toString() {
		return "DEFINE";
	}

	@Override
	public String name()  {
		return null;
	}
}
