package statements.keywords;

import interpreter.NoBracesStack;
import statements.AbstractStatement;

public class DefinedAs extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) throws MalformedProgramException {
		throw new MalformedProgramException("==");
	}
	
	@Override
	public String toString() {
		return "==";		
	}

	@Override
	public String name() {
		return null;
	}
}
