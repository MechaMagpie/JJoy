package statements.functions.meta;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.ListStatement;

public class I extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		ListStatement p = (ListStatement) stackState.pop();
		p.dequote(stackState);
	}

	@Override
	public String toString() {
		return "i";
	}
}
