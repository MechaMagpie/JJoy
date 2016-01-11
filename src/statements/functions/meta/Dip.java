package statements.functions.meta;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.ListStatement;

public class Dip extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		ListStatement p = (ListStatement) stackState.pop();
		AbstractStatement x = stackState.pop();
		p.dequote(stackState);
		stackState.push(x);
	}

}
