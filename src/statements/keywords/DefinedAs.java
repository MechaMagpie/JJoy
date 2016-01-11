package statements.keywords;

import interpreter.NoBracesStack;
import statements.AbstractStatement;

public class DefinedAs extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		//TODO: better exception
		throw new RuntimeException("Attempting to evaulate delimiter: ==");
	}
	
	@Override
	public String toString() {
		return "==";		
	}
}
