package statements.functions;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.ListStatement;
import statements.PushInteger;

public class Times extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		ListStatement p = (ListStatement) stackState.pop();
		PushInteger n = (PushInteger) stackState.pop();
		for(long count = n.extractValue(); count > 0; count--) {
			p.dequote(stackState);
		}
	}

	@Override
	public String toString() {
		return "times";
	}
}
